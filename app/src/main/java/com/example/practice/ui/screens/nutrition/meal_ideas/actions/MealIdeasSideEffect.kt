package com.example.practice.ui.screens.nutrition.meal_ideas.actions

sealed class MealIdeasSideEffect {
    data object Empty : MealIdeasSideEffect()
    data class ShowNavigationMealIdeasInfo(val mealIdeaId: String, val recipeId: String) : MealIdeasSideEffect()
    data object ShowNavigationBack : MealIdeasSideEffect()
}