package com.example.practice.domain.models

data class MealIdea(
    val id: String,
    val totalCalories: Int,
    val totalTimeMinutes: Int,
    val selectedDate: String? = null,
    val todayState: MealIdeaTodayState = MealIdeaTodayState.NotSelected,
    val sortOrder: Int,
    val createdAtMillis: Long,
    val recipes: List<MealIdeaRecipe>
)

data class MealIdeaRecipe(
    val mealIdeaId: String,
    val recipeId: String,
    val mealType: MealType,
    val position: Int
)

enum class MealIdeaTodayState {
    NotSelected,
    SelectedToday,
    SelectedPastDay
}