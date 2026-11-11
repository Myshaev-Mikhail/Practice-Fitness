package com.example.practice.domain.models

data class RecipeType(
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String,
    val imagePath: String,
    val caloriesPerServing: Int,
    val totalTimeMinutes: Int,
    val allergensVerified: Boolean,
    val batchServings: Int? = null,
    val servingDescriptionRu: String? = null,
    val servingDescriptionEn: String? = null,
    val snackAddition: Boolean = false,
    val completeTimeKnown: Boolean = true
)

data class RecipeIngredient(
    val recipeId: String,
    val position: Int,
    val nameIngredientsRu: String,
    val nameIngredientsEn: String,
    val amount: Double?,
    val ingredientUnit: IngredientUnit?,
    val noteRu: String?,
    val noteEn: String?
)

data class RecipeStep(
    val recipeId: String,
    val position: Int,
    val textRu: String,
    val textEn: String
)

data class RecipeFull(
    val recipe: RecipeType,
    val ingredients: List<RecipeIngredient>,
    val steps: List<RecipeStep>,
    val mealTypes: Set<MealType>,
    val dietaryPreferences: Set<DietaryPreference>,
    val allergens: Set<Allergy>
)

enum class IngredientUnit {
    MILLILITER,
    GRAM,
    PIECE,
    TEASPOON,
    TABLESPOON,
    CUP,
    CLOVE
}
