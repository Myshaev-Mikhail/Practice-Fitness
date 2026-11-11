package com.example.practice.domain.usecase

import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.CalorieGoal
import com.example.practice.domain.models.CookingTime
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealIdea
import com.example.practice.domain.models.MealIdeaRecipe
import com.example.practice.domain.models.MealIdeaTodayState
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeFull
import com.example.practice.domain.repository.MealIdeasRepository
import com.example.practice.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MealIdeasUseCase(
    private val recipeRepository: RecipeRepository,
    private val mealIdeasRepository: MealIdeasRepository
) {
    suspend fun hasSavedMealIdeas(): Boolean =
        mealIdeasRepository.getMealIdeas().any { it.recipes.isNotEmpty() }

    fun observeMealIdeas(): Flow<List<MealIdea>> {
        return combine(mealIdeasRepository.observeMealIdeas(), observeCurrentDate()) { mealIdeas, today ->
            mealIdeas.map { it.withTodayState(today) }.sortedWith(
                compareBy<MealIdea> {
                    when (it.todayState) {
                        MealIdeaTodayState.SelectedToday -> 0
                        MealIdeaTodayState.NotSelected -> 1
                        MealIdeaTodayState.SelectedPastDay -> 2
                    }
                }.thenBy { it.sortOrder }
            )
        }
    }

    private fun observeCurrentDate(): Flow<String> = flow {
        while (true) {
            val now = Calendar.getInstance()
            emit(currentDate(now.time))
            val nextDay = (now.clone() as Calendar).apply {
                add(Calendar.DAY_OF_MONTH, 1)
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
            delay((nextDay.timeInMillis - System.currentTimeMillis()).coerceAtLeast(1))
        }
    }

    suspend fun generateAndSaveMealIdeas(
        preferences: MealPlanPreferences
    ): GenerationResult {
        val recipes = recipeRepository.getAllRecipeDetails()
        val result = withContext(Dispatchers.Default) {
            buildMealIdeas(preferences, recipes)
        }
        if (result is GenerationResult.Saved) {
            mealIdeasRepository.replaceMealIdeas(result.mealIdeas)
        }
        return result
    }

    sealed interface GenerationResult {
        data class Saved(val mealIdeas: List<MealIdea>) : GenerationResult
        data object NoMealsMatch : GenerationResult
        data object CalorieGoalUnavailable : GenerationResult
    }

    suspend fun selectMealIdeaForToday(mealIdeaId: String) {
        mealIdeasRepository.selectMealIdeaForDate(
            mealIdeaId = mealIdeaId,
            date = currentDate()
        )
    }

    suspend fun toggleMealIdeaForToday(mealIdeaId: String) {
        mealIdeasRepository.toggleMealIdeaForDate(mealIdeaId, currentDate())
    }

    suspend fun prepareNextCycleIfNeeded() {
        val today = currentDate()
        val mealIdeas = mealIdeasRepository.getMealIdeas()
        if (mealIdeas.isEmpty()) return

        val hasSelectedMealIdeaToday = mealIdeas.any { it.selectedDate == today }
        if (mealIdeas.all { it.selectedDate != null } && !hasSelectedMealIdeaToday) {
            mealIdeasRepository.resetTriedFlagsAndUpdateSortOrder(
                sortOrderById = mealIdeas
                    .shuffled()
                    .mapIndexed { index, mealIdea -> mealIdea.id to index }
                    .toMap()
            )
        }
    }

    private fun buildMealIdeas(
        preferences: MealPlanPreferences,
        recipes: List<RecipeFull>
    ): GenerationResult {
        val selectedMealTypes = orderedMealTypes.filter { it in preferences.mealTypes }
        if (selectedMealTypes.isEmpty()) return GenerationResult.NoMealsMatch

        val filteredRecipes = recipes.filter { recipe ->
            recipe.matchesDietaryPreferences(preferences.dietaryPreferences) &&
                recipe.matchesAllergens(preferences.allergens) &&
                recipe.matchesCookingTime(preferences.cookingTime)
        }

        val snackAdditions = filteredRecipes.filter { it.recipe.snackAddition }
        val mealOptions = selectedMealTypes.map { mealType ->
            filteredRecipes
                .filter { mealType in it.mealTypes && !it.recipe.snackAddition }
                .flatMap { recipe ->
                    val main = listOf(MealSlot(mealType, recipe))
                    if (mealType == MealType.SNACKS && recipe.recipe.id in dipPairings) {
                        listOf(main) + snackAdditions.mapNotNull { dip ->
                            val minutes = recipe.recipe.totalTimeMinutes + dip.recipe.totalTimeMinutes
                            if (!preferences.cookingTime.allows(minutes)) return@mapNotNull null
                            main + MealSlot(mealType, dip)
                        }
                    } else {
                        listOf(main)
                    }
                }
        }

        val candidates = buildCombinations(mealOptions)
        if (candidates.isEmpty()) return GenerationResult.NoMealsMatch

        val combinations = if (preferences.isFullDay) {
            candidates.filterByCalorieGoal(preferences.calorieGoal)
        } else {
            candidates
        }.take(DEFAULT_MAX_MEAL_IDEAS)
        if (combinations.isEmpty()) return GenerationResult.CalorieGoalUnavailable

        val createdAtMillis = System.currentTimeMillis()
        val mealIdeas = combinations.mapIndexed { index, slots ->
            val id = slots.joinToString(
                separator = "-",
                prefix = "meal-idea-"
            ) { "${it.mealType.name.lowercase()}-${it.recipe.recipe.id}" }

            MealIdea(
                id = id,
                totalCalories = slots.sumOf { it.recipe.recipe.caloriesPerServing },
                totalTimeMinutes = slots.sumOf { it.recipe.recipe.totalTimeMinutes },
                selectedDate = null,
                todayState = MealIdeaTodayState.NotSelected,
                sortOrder = index,
                createdAtMillis = createdAtMillis,
                recipes = slots.mapIndexed { position, slot ->
                    MealIdeaRecipe(
                        mealIdeaId = id,
                        recipeId = slot.recipe.recipe.id,
                        mealType = slot.mealType,
                        position = position
                    )
                }
            )
        }
        return GenerationResult.Saved(mealIdeas)
    }

    private fun buildCombinations(
        mealOptions: List<List<List<MealSlot>>>
    ): List<List<MealSlot>> {
        var combinations = listOf(emptyList<MealSlot>())
        mealOptions.forEach { options ->
            if (options.isEmpty()) return emptyList()

            combinations = combinations.flatMap { current ->
                options.map { current + it }
            }
        }

        return combinations
            .filter { slots ->
                slots.map { it.recipe.recipe.id }.distinct().size == slots.size
            }
            .shuffled()
    }

    private fun List<List<MealSlot>>.filterByCalorieGoal(
        calorieGoal: CalorieGoal?
    ): List<List<MealSlot>> {
        val filtered = when (calorieGoal) {
            CalorieGoal.UNDER_1500 -> {
                val primary = filter { it.totalCalories in 1000..1200 }
                val fallback = filter { it.totalCalories in 1201..1499 }
                primary + fallback
            }

            CalorieGoal.FROM_1500_TO_2000 -> {
                filter { it.totalCalories in 1500..2000 }
            }

            CalorieGoal.OVER_2000 -> {
                val primary = filter { it.totalCalories in 2500..3000 }
                val fallback = filter { it.totalCalories in 2001..2499 }
                primary + fallback
            }

            CalorieGoal.NO_GOAL,
            null -> this
        }

        return filtered
    }

    private fun RecipeFull.matchesDietaryPreferences(
        preferences: Set<DietaryPreference>?
    ): Boolean {
        val selectedPreferences = preferences.orEmpty() - DietaryPreference.NO_PREFERENCE
        return selectedPreferences.isEmpty() || selectedPreferences.all { it in dietaryPreferences }
    }

    private fun RecipeFull.matchesAllergens(
        allergies: Set<Allergy>?
    ): Boolean {
        val selectedAllergies = allergies.orEmpty() - Allergy.NONE
        return selectedAllergies.isEmpty() || allergens.none { it in selectedAllergies }
    }

    private fun RecipeFull.matchesCookingTime(
        cookingTime: CookingTime?
    ): Boolean {
        return cookingTime.allows(recipe.totalTimeMinutes, recipe.completeTimeKnown)
    }

    private fun CookingTime?.allows(minutes: Int, completeTimeKnown: Boolean = true): Boolean {
        return when (this) {
            CookingTime.UNDER_15_MINUTES -> completeTimeKnown && minutes <= 15
            CookingTime.UNDER_30_MINUTES -> completeTimeKnown && minutes <= 30
            CookingTime.NO_LIMIT,
            null -> true
        }
    }

    private fun currentDate(date: Date = Date()): String {
        return SimpleDateFormat(DATE_PATTERN, Locale.US).format(date)
    }

    private fun MealIdea.withTodayState(today: String): MealIdea {
        return copy(
            todayState = when (selectedDate) {
                null -> MealIdeaTodayState.NotSelected
                today -> MealIdeaTodayState.SelectedToday
                else -> MealIdeaTodayState.SelectedPastDay
            }
        )
    }

    private val List<MealSlot>.totalCalories: Int
        get() = sumOf { it.recipe.recipe.caloriesPerServing }

    private data class MealSlot(
        val mealType: MealType,
        val recipe: RecipeFull
    )

    companion object {
        private const val DEFAULT_MAX_MEAL_IDEAS = 30
        private const val DATE_PATTERN = "yyyy-MM-dd"

        private val orderedMealTypes = listOf(
            MealType.BREAKFAST,
            MealType.LUNCH,
            MealType.DINNER,
            MealType.SNACKS
        )
        private val dipPairings = setOf("perfect-hard-cooked-eggs", "baked-tomatoes-with-cheese")
    }
}
