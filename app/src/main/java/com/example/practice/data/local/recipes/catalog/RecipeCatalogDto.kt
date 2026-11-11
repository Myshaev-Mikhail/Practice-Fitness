package com.example.practice.data.local.recipes.catalog

import kotlinx.serialization.Serializable

@Serializable
data class RecipeCatalogDto(
    val schemaVersion: Int,
    val catalogVersion: String,
    val recipes: List<CatalogRecipeDto>
)

@Serializable
data class CatalogRecipeDto(
    val recipe: RecipeDto,
    val ingredients: List<RecipeIngredientDto>,
    val steps: List<RecipeStepDto>,
    val mealTypes: List<String>,
    val dietaryPreferences: List<String>,
    val allergens: List<String>,
    val additionalAllergens: List<String> = emptyList(),
    val serving: RecipeServingDto,
    val review: RecipeReviewDto,
    val snackAddition: Boolean = false
)

@Serializable
data class RecipeServingDto(
    val batchServings: Int,
    val descriptionRu: String,
    val descriptionEn: String
)

@Serializable
data class RecipeReviewDto(
    val completeTimeSuitableForFiltering: Boolean
)

@Serializable
data class RecipeDto(
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String,
    val imagePath: String,
    val caloriesPerServing: Int,
    val totalTimeMinutes: Int,
    val allergensVerified: Boolean
)

@Serializable
data class RecipeStepDto(
    val recipeId: String,
    val position: Int,
    val textRu: String,
    val textEn: String
)

@Serializable
data class RecipeIngredientDto(
    val recipeId: String,
    val position: Int,
    val nameIngredientsRu: String,
    val nameIngredientsEn: String,
    val amount: Double? = null,
    val ingredientUnit: String? = null,
    val noteRu: String? = null,
    val noteEn: String? = null,
    val sourceTextEn: String? = null,
    val sourceLocation: String? = null
)
