package com.example.practice.ui.screens.nutrition.meal_ideas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.IngredientUnit
import com.example.practice.domain.models.MealIdeaTodayState
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeIngredient
import com.example.practice.domain.models.RecipeStep
import com.example.practice.domain.usecase.MealIdeasUseCase
import com.example.practice.domain.usecase.RecipeUseCase
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.IngredientUnitUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaCardUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaDetailsUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaDishUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaTodayStateUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasAction
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasSideEffect
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasState
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealTypeUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeFullUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeIngredientUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeStepUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class MealIdeasViewModel(
    private val mealIdeasUseCase: MealIdeasUseCase,
    private val recipeUseCase: RecipeUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(MealIdeasState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<MealIdeasSideEffect>(MealIdeasSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        observeMealIdeaCards()
    }

    fun handleUiAction(action: MealIdeasAction) {
        when(action) {
            is MealIdeasAction.NavigationMealIdeasInfoPressed -> {
                openMealIdeaDetails(mealIdeaId = action.mealIdeaId, recipeId = action.recipeId)
            }

            is MealIdeasAction.NavigationBackPressed -> {
                sideEffectFlow.value = MealIdeasSideEffect.ShowNavigationBack
            }

            is MealIdeasAction.ToggleMealIdeaForTodayPressed -> {
                toggleMealIdeaForToday(action.mealIdeaId)
            }
        }
    }

    private fun observeMealIdeaCards() {
        viewModelScope.launch {
            combine(
                mealIdeasUseCase.observeMealIdeas(),
                recipeUseCase.observeRecipes()
            ) { mealIdeas, recipes ->
                val recipesById = recipes.associateBy { it.id }

                mealIdeas.map { mealIdea ->
                    MealIdeaCardUi(
                        id = mealIdea.id,
                        dishes = mealIdea.recipes.mapNotNull { item ->
                            val recipe = recipesById[item.recipeId] ?: return@mapNotNull null

                            MealIdeaDishUi(
                                recipeId = recipe.id,
                                mealType = item.mealType.toUi(),
                                nameRu = recipe.nameRu,
                                nameEn = recipe.nameEn,
                                imagePath = recipe.imagePath,
                                calories = recipe.caloriesPerServing,
                                timeMinutes = recipe.totalTimeMinutes,
                                snackAddition = recipe.snackAddition
                            )
                        },
                        totalCalories = mealIdea.totalCalories,
                        totalTimeMinutes = mealIdea.totalTimeMinutes,
                        todayState = mealIdea.todayState.toUi()
                    )
                }
            }.collect { cards ->
                uiStateFlow.update { state ->
                    state.copy(
                        mealIdeaCards = cards,
                        selectedMealIdea = state.selectedMealIdea
                            ?.syncTodayState(cards)
                    )
                }
            }
        }
    }

    fun openMealIdeaDetails(mealIdeaId: String, recipeId: String) {
        sideEffectFlow.value = MealIdeasSideEffect.ShowNavigationMealIdeasInfo(
            mealIdeaId = mealIdeaId,
            recipeId = recipeId
        )
    }

    fun loadMealIdeaDetails(mealIdeaId: String) {
        viewModelScope.launch {
            uiStateFlow.update {
                it.copy(
                    selectedMealIdea = null,
                    isDetailsLoading = true,
                    errorMessage = null
                )
            }

            try {
                val mealIdea = mealIdeasUseCase.observeMealIdeas().first()
                    .firstOrNull { it.id == mealIdeaId }
                    ?: error("Meal idea $mealIdeaId not found")
                val fullRecipes = mealIdea.recipes.map { dish ->
                    val recipeFull = recipeUseCase
                        .getRecipeDetails(dish.recipeId)
                        ?: throw IllegalStateException(
                            "Recipe ${dish.recipeId} not found"
                        )

                    RecipeFullUi(
                        recipeId = recipeFull.recipe.id,
                        mealType = dish.mealType.toUi(),
                        nameRu = recipeFull.recipe.nameRu,
                        nameEn = recipeFull.recipe.nameEn,
                        descriptionRu = recipeFull.recipe.descriptionRu,
                        descriptionEn = recipeFull.recipe.descriptionEn,
                        imagePath = recipeFull.recipe.imagePath,
                        calories = recipeFull.recipe.caloriesPerServing,
                        timeMinutes = recipeFull.recipe.totalTimeMinutes,
                        ingredients = recipeFull.ingredients.map { it.toUi() },
                        steps = recipeFull.steps.map { it.toUi() },
                        batchServings = recipeFull.recipe.batchServings,
                        servingDescriptionRu = recipeFull.recipe.servingDescriptionRu,
                        servingDescriptionEn = recipeFull.recipe.servingDescriptionEn,
                        snackAddition = recipeFull.recipe.snackAddition
                    )
                }

                val mealIdeaDetails = MealIdeaDetailsUi(
                    id = mealIdea.id,
                    totalCalories = mealIdea.totalCalories,
                    totalTimeMinutes = mealIdea.totalTimeMinutes,
                    todayState = mealIdea.todayState.toUi(),
                    dishes = fullRecipes
                )

                uiStateFlow.update {
                    it.copy(
                        selectedMealIdea = mealIdeaDetails,
                        isDetailsLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                uiStateFlow.update {
                    it.copy(
                        selectedMealIdea = null,
                        isDetailsLoading = false,
                        errorMessage = "Не удалось загрузить подробности блюд"
                    )
                }
            }
        }
    }

    private fun toggleMealIdeaForToday(mealIdeaId: String) {
        viewModelScope.launch {
            mealIdeasUseCase.toggleMealIdeaForToday(mealIdeaId)
        }
    }

    private fun MealIdeaDetailsUi.syncTodayState(
        cards: List<MealIdeaCardUi>
    ): MealIdeaDetailsUi {
        val card = cards.firstOrNull { it.id == id } ?: return this
        return copy(todayState = card.todayState)
    }

    private fun MealType.toUi(): MealTypeUi {
        return when (this) {
            MealType.BREAKFAST -> MealTypeUi.Breakfast
            MealType.LUNCH -> MealTypeUi.Lunch
            MealType.DINNER -> MealTypeUi.Dinner
            MealType.SNACKS -> MealTypeUi.Snacks
        }
    }

    private fun MealIdeaTodayState.toUi(): MealIdeaTodayStateUi {
        return when (this) {
            MealIdeaTodayState.NotSelected -> MealIdeaTodayStateUi.NotSelected
            MealIdeaTodayState.SelectedToday -> MealIdeaTodayStateUi.SelectedToday
            MealIdeaTodayState.SelectedPastDay -> MealIdeaTodayStateUi.SelectedPastDay
        }
    }

    private fun RecipeIngredient.toUi(): RecipeIngredientUi {
        return RecipeIngredientUi(
            recipeId = recipeId,
            position = position,
            nameIngredientsRu = nameIngredientsRu,
            nameIngredientsEn = nameIngredientsEn,
            amount = amount,
            ingredientUnit = ingredientUnit?.toUi(),
            noteRu = noteRu,
            noteEn = noteEn
        )
    }

    private fun RecipeStep.toUi(): RecipeStepUi {
        return RecipeStepUi(
            recipeId = recipeId,
            position = position,
            textRu = textRu,
            textEn = textEn
        )
    }

    private fun IngredientUnit.toUi(): IngredientUnitUi {
        return when (this) {
            IngredientUnit.MILLILITER -> IngredientUnitUi.Milliliter
            IngredientUnit.GRAM -> IngredientUnitUi.Gram
            IngredientUnit.PIECE -> IngredientUnitUi.Piece
            IngredientUnit.TEASPOON -> IngredientUnitUi.Teaspoon
            IngredientUnit.TABLESPOON -> IngredientUnitUi.Tablespoon
            IngredientUnit.CUP -> IngredientUnitUi.Cup
            IngredientUnit.CLOVE -> IngredientUnitUi.Clove
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = MealIdeasSideEffect.Empty
    }
}
