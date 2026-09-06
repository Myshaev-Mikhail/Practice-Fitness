package com.example.practice.ui.screens.nutrition.meal_plans

import com.example.practice.R
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanMessage
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.CalorieGoal
import com.example.practice.domain.models.CookingTime
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.ServingsOption
import com.example.practice.domain.usecase.MealPlanUseCase
import com.example.practice.ui.screens.nutrition.meal_plans.actions.CheckboxItem
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanAction
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanAnswer
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanOption
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanSideEffect
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MealPlanViewModel(
    private val mealPlanUseCase: MealPlanUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(MealPlanState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<MealPlanSideEffect>(MealPlanSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        loadMealPlan()
    }

    fun handleUiAction(action: MealPlanAction) {
        when (action) {
            is MealPlanAction.NavigateBackPressed -> {
                sideEffectFlow.value = MealPlanSideEffect.ShowNavigateBack
            }

            is MealPlanAction.StartMealPlanPressed -> {
                sideEffectFlow.value = MealPlanSideEffect.ShowNavigationNext
            }

            is MealPlanAction.NavigationNextPressed -> {
                if (!uiStateFlow.value.isSaving && validateAnswers(includeGoals = false)) {
                    sideEffectFlow.value = MealPlanSideEffect.ShowNavigationNext
                }
            }

            is MealPlanAction.MealPlanCreatedPressed -> {
                saveMealPlan()
            }

            is MealPlanAction.DietaryPreferenceClicked -> {
                toggleDietaryPreference(action.value)
            }

            is MealPlanAction.AllergyClicked -> {
                toggleAllergy(action.value)
            }

            is MealPlanAction.MealTypeClicked -> {
                toggleMealType(action.value)
            }

            is MealPlanAction.CalorieGoalClicked -> {
                selectCalorieGoal(action.value)
            }

            is MealPlanAction.CookingTimeClicked -> {
                selectCookingTime(action.value)
            }

            is MealPlanAction.ServingsOptionClicked -> {
                selectServings(action.value)
            }
        }
    }

    private fun loadMealPlan() {
        uiStateFlow.update {
            it.copy(
                preferencesItems = preferencesItems,
                goalsItems = goalsItems
            )
        }
    }

    private fun changePreferences(
        transform: (MealPlanPreferences) -> MealPlanPreferences
    ) {
        uiStateFlow.update { state ->
            if (state.isSaving) state else state.copy(
                preferences = transform(state.preferences), errorMessage = null
            )
        }
    }

    // NONE хранится отдельно от конкретных вариантов и исключает их.
    private fun <T> toggleExclusive(current: Set<T>?, value: T, none: T): Set<T>? {
        if (value == none) return setOf(none)
        val selected = current.orEmpty() - none
        val result = if (value in selected) selected - value else selected + value
        return result.takeIf { it.isNotEmpty() }
    }

    fun toggleDietaryPreference(value: DietaryPreference) = changePreferences {
        it.copy(dietaryPreferences = toggleExclusive(
            it.dietaryPreferences, value, DietaryPreference.NO_PREFERENCE
        ))
    }

    fun toggleAllergy(value: Allergy) = changePreferences {
        it.copy(allergens = toggleExclusive(it.allergens, value, Allergy.NONE))
    }

    fun toggleMealType(value: MealType) = changePreferences {
        it.copy(mealTypes = if (value in it.mealTypes) it.mealTypes - value else it.mealTypes + value)
    }

    fun selectCalorieGoal(value: CalorieGoal) = changePreferences { it.copy(calorieGoal = value) }
    fun selectCookingTime(value: CookingTime): Unit = changePreferences { it.copy(cookingTime = value) }
    fun selectServings(value: ServingsOption) = changePreferences { it.copy(servings = value) }

    private fun validateAnswers(includeGoals: Boolean): Boolean {
        val answers = uiStateFlow.value.preferences
        val missing = buildList {
            if (answers.dietaryPreferences.isNullOrEmpty()) add(R.string.meal_plan_dietary_title)
            if (answers.allergens.isNullOrEmpty()) add(R.string.meal_plan_allergy_title)
            if (answers.mealTypes.isEmpty()) add(R.string.meal_plan_meal_type_title)
            if (includeGoals) {
                if (answers.calorieGoal == null) add(R.string.meal_plan_calorie_title)
                if (answers.cookingTime == null) add(R.string.meal_plan_cooking_title)
                if (answers.servings == null) add(R.string.meal_plan_servings_title)
            }
        }
        uiStateFlow.update {
            it.copy(errorMessage = missing.takeIf { it.isNotEmpty() }?.let {
                MealPlanMessage(R.string.meal_plan_missing_answers, it)
            })
        }
        return missing.isEmpty()
    }

    fun saveMealPlan() {
        val state = uiStateFlow.value
        if (state.isSaving) return
        if (!validateAnswers(includeGoals = true)) return
        val answers = state.preferences
        uiStateFlow.update { it.copy(isSaving = true, errorMessage = null) }
        viewModelScope.launch {
            try {
                mealPlanUseCase.saveMealPlan(answers)
                sideEffectFlow.value = MealPlanSideEffect.ShowMealPlanCreated
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                uiStateFlow.update { it.copy(errorMessage = MealPlanMessage(R.string.meal_plan_save_error)) }
            } finally {
                uiStateFlow.update { it.copy(isSaving = false) }
            }
        }
    }

    fun clearErrorMessage() {
        uiStateFlow.update { it.copy(errorMessage = null) }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = MealPlanSideEffect.Empty
    }

    companion object {
        val preferencesItems = listOf(
            MealPlanOption(
                title = R.string.meal_plan_dietary_title,
                question = R.string.meal_plan_dietary_question,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.VEGETARIAN),
                        label = R.string.meal_plan_vegetarian,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.VEGAN),
                        label = R.string.meal_plan_vegan,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.GLUTEN_FREE),
                        label = R.string.meal_plan_gluten_free,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.KETO),
                        label = R.string.meal_plan_keto,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.PALEO),
                        label = R.string.meal_plan_paleo,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Dietary(DietaryPreference.NO_PREFERENCE),
                        label = R.string.meal_plan_no_preference,
                    )
                )
            ),
            MealPlanOption(
                title = R.string.meal_plan_allergy_title,
                question = R.string.meal_plan_allergy_question,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Allergen(Allergy.NUTS),
                        label = R.string.meal_plan_nuts,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Allergen(Allergy.DAIRY),
                        label = R.string.meal_plan_dairy,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Allergen(Allergy.SHELLFISH),
                        label = R.string.meal_plan_shellfish,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Allergen(Allergy.EGGS),
                        label = R.string.meal_plan_eggs,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Allergen(Allergy.NONE),
                        label = R.string.meal_plan_no_allergies,
                    )
                )
            ),
            MealPlanOption(
                title = R.string.meal_plan_meal_type_title,
                question = R.string.meal_plan_meal_type_question,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Meal(MealType.BREAKFAST),
                        label = R.string.meal_plan_breakfast,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Meal(MealType.LUNCH),
                        label = R.string.meal_plan_lunch,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Meal(MealType.DINNER),
                        label = R.string.meal_plan_dinner,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Meal(MealType.SNACKS),
                        label = R.string.meal_plan_snacks,
                    )
                )
            )
        )

        val goalsItems = listOf(
            MealPlanOption(
                title = R.string.meal_plan_calorie_title,
                question = R.string.meal_plan_calorie_question,
                columns = 1,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Calories(CalorieGoal.UNDER_1500),
                        label = R.string.meal_plan_calorie_under_1500,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Calories(CalorieGoal.FROM_1500_TO_2000),
                        label = R.string.meal_plan_calorie_1500_2000,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Calories(CalorieGoal.OVER_2000),
                        label = R.string.meal_plan_calorie_over_2000,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Calories(CalorieGoal.NO_GOAL),
                        label = R.string.meal_plan_calorie_no_goal,
                    )
                )
            ),
            MealPlanOption(
                title = R.string.meal_plan_cooking_title,
                question = R.string.meal_plan_cooking_question,
                columns = 1,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Cooking(CookingTime.UNDER_15_MINUTES),
                        label = R.string.meal_plan_cooking_under_15,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Cooking(CookingTime.FROM_15_TO_30_MINUTES),
                        label = R.string.meal_plan_cooking_15_30,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Cooking(CookingTime.OVER_30_MINUTES),
                        label = R.string.meal_plan_cooking_over_30,
                    )
                )
            ),
            MealPlanOption(
                title = R.string.meal_plan_servings_title,
                question = R.string.meal_plan_servings_question,
                checkboxItem = listOf(
                    CheckboxItem(
                        answer = MealPlanAnswer.Servings(ServingsOption.ONE),
                        label = R.string.meal_plan_servings_one,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Servings(ServingsOption.TWO),
                        label = R.string.meal_plan_servings_two,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Servings(ServingsOption.THREE_TO_FOUR),
                        label = R.string.meal_plan_servings_three_four,
                    ),
                    CheckboxItem(
                        answer = MealPlanAnswer.Servings(ServingsOption.MORE_THAN_FOUR),
                        label = R.string.meal_plan_servings_over_four,
                    )
                )
            )
        )
    }
}
