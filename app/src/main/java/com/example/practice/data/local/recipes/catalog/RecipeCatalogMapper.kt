package com.example.practice.data.local.recipes.catalog

import com.example.practice.data.local.recipes.RecipeAllergenEntity
import com.example.practice.data.local.recipes.RecipeDetails
import com.example.practice.data.local.recipes.RecipeDietaryPreferenceEntity
import com.example.practice.data.local.recipes.RecipeEntity
import com.example.practice.data.local.recipes.RecipeIngredients
import com.example.practice.data.local.recipes.RecipeMealTypeEntity
import com.example.practice.data.local.recipes.RecipeSteps
import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.IngredientUnit
import com.example.practice.domain.models.MealType

fun RecipeIngredientDto.toEntity(): RecipeIngredients {
    return RecipeIngredients(
        recipeId = recipeId,
        position = position,
        nameIngredientsRu = nameIngredientsRu,
        nameIngredientsEn = nameIngredientsEn,
        amount = amount,
        ingredientUnit = ingredientUnit?.let {
            IngredientUnit.valueOf(it)
        },
        noteRu = noteRu,
        noteEn = noteEn
    )
}

private fun CatalogRecipeDto.toEntity(catalogVersion: String): RecipeEntity = with(recipe) {
    RecipeEntity(
        id = id,
        nameRu = nameRu,
        nameEn = nameEn,
        descriptionRu = descriptionRu,
        descriptionEn = descriptionEn,
        imagePath = imagePath,
        caloriesPerServing = caloriesPerServing,
        totalTimeMinutes = totalTimeMinutes,
        allergensVerified = allergensVerified,
        batchServings = serving.batchServings,
        servingDescriptionRu = serving.descriptionRu,
        servingDescriptionEn = serving.descriptionEn,
        snackAddition = snackAddition,
        completeTimeKnown = review.completeTimeSuitableForFiltering,
        catalogVersion = catalogVersion
    )
}

fun RecipeStepDto.toEntity(): RecipeSteps {
    return RecipeSteps(
        recipeId = recipeId,
        position = position,
        textRu = textRu,
        textEn = textEn
    )
}

private fun CatalogRecipeDto.toDetails(catalogVersion: String): RecipeDetails {
    return RecipeDetails(
        recipe = toEntity(catalogVersion),
        ingredients = ingredients.map { it.toEntity() },
        steps = steps.map { it.toEntity() },
        mealTypes = mealTypes.map {
            val mealType = MealType.valueOf(it)
            RecipeMealTypeEntity(
                recipeId = recipe.id,
                mealType = mealType.name
            )
        },
        dietaryPreferences = dietaryPreferences.map {
            val preference = DietaryPreference.valueOf(it)
            RecipeDietaryPreferenceEntity(
                recipeId = recipe.id,
                dietaryPreference = preference.name
            )
        },
        allergens = (
            allergens.map { Allergy.valueOf(it) } +
                additionalAllergens.mapNotNull { it.toSupportedAllergyOrNull() }
            )
            .distinct()
            .map {
                RecipeAllergenEntity(
                    recipeId = recipe.id,
                    allergen = it.name
                )
            }
    )
}

fun RecipeCatalogDto.toDetails(): List<RecipeDetails> {
    return recipes.map { it.toDetails(catalogVersion) }
}

private fun String.toSupportedAllergyOrNull(): Allergy? {
    return when (this) {
        Allergy.NUTS.name,
        "PEANUT" -> Allergy.NUTS
        Allergy.DAIRY.name -> Allergy.DAIRY
        Allergy.SHELLFISH.name -> Allergy.SHELLFISH
        Allergy.EGGS.name -> Allergy.EGGS
        else -> null
    }
}
