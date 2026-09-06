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
    UNDER_15_MINUTES, FROM_15_TO_30_MINUTES, OVER_30_MINUTES
}

enum class ServingsOption {
    ONE, TWO, THREE_TO_FOUR, MORE_THAN_FOUR
}

data class MealPlanPreferences(
    val dietaryPreferences: Set<DietaryPreference>? = null,
    val allergens: Set<Allergy>? = null,
    val mealTypes: Set<MealType> = emptySet(),
    val calorieGoal: CalorieGoal? = null,
    val cookingTime: CookingTime? = null,
    val servings: ServingsOption? = null
)