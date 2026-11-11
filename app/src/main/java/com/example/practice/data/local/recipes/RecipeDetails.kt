package com.example.practice.data.local.recipes

data class RecipeDetails(
    val recipe: RecipeEntity,
    val ingredients: List<RecipeIngredients>,
    val steps: List<RecipeSteps>,
    val mealTypes: List<RecipeMealTypeEntity>,
    val dietaryPreferences: List<RecipeDietaryPreferenceEntity>,
    val allergens: List<RecipeAllergenEntity>
)
