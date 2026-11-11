package com.example.practice.ui.screens.nutrition.meal_ideas.actions

sealed class MealIdeasAction {
    data class NavigationMealIdeasInfoPressed(val mealIdeaId: String, val recipeId: String) : MealIdeasAction()
    data class ToggleMealIdeaForTodayPressed(val mealIdeaId: String) : MealIdeasAction()
    data object NavigationBackPressed : MealIdeasAction()
}
