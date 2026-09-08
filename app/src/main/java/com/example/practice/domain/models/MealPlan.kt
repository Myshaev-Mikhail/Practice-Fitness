package com.example.practice.domain.models

enum class DietaryPreference {
    VEGETARIAN, VEGAN, GLUTEN_FREE, KETO, PALEO, NO_PREFERENCE
}

enum class Allergy {
    NUTS, DAIRY, SHELLFISH, EGGS, NONE
}

enum class MealType {
    BREAKFAST, LUNCH, DINNER, SNACKS
}

enum class CalorieGoal {
    UNDER_1500, FROM_1500_TO_2000, OVER_2000, NO_GOAL
}

enum class CookingTime {
    UNDER_15_MINUTES, UNDER_30_MINUTES, NO_LIMIT
}

data class MealPlanPreferences(
    val dietaryPreferences: Set<DietaryPreference>? = null,
    val allergens: Set<Allergy>? = null,
    val mealTypes: Set<MealType> = emptySet(),
    val calorieGoal: CalorieGoal? = null,
    val cookingTime: CookingTime? = null
)