package com.example.practice.ui.screens.nutrition.meal_plans.actions

sealed class MealPlanSideEffect {
    data object Empty: MealPlanSideEffect()
    data object ShowNavigateBack: MealPlanSideEffect()
    data object ShowNavigationNext: MealPlanSideEffect()
    data object ShowMealPlanCreated : MealPlanSideEffect()
}