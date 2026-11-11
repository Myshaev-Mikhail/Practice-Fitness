package com.example.practice.data.local.recipes

import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeFull
import com.example.practice.domain.models.RecipeIngredient
import com.example.practice.domain.models.RecipeStep
import com.example.practice.domain.models.RecipeType

fun RecipeEntity.toDomain(): RecipeType {
    return RecipeType(
        id = this.id,
        nameRu = this.nameRu,
        nameEn = this.nameEn,
        descriptionRu = this.descriptionRu,
        descriptionEn = this.descriptionEn,
        imagePath = this.imagePath,
        caloriesPerServing = this.caloriesPerServing,
        totalTimeMinutes = this.totalTimeMinutes,
        allergensVerified = this.allergensVerified,
        batchServings = batchServings,
        servingDescriptionRu = servingDescriptionRu,
        servingDescriptionEn = servingDescriptionEn,
        snackAddition = snackAddition == true,
        completeTimeKnown = completeTimeKnown != false
    )
}

fun RecipeIngredients.toDomain(): RecipeIngredient {
    return RecipeIngredient(
        recipeId = this.recipeId,
        position = this.position,
        nameIngredientsRu = this.nameIngredientsRu,
        nameIngredientsEn = this.nameIngredientsEn,
        amount = this.amount,
        ingredientUnit = this.ingredientUnit,
        noteRu = this.noteRu,
        noteEn = this.noteEn
    )
}

fun RecipeSteps.toDomain(): RecipeStep {
    return RecipeStep(
        recipeId = this.recipeId,
        position = this.position,
        textRu = this.textRu,
        textEn = this.textEn
    )
}

fun RecipeDetails.toDomain(): RecipeFull {
    return RecipeFull(
        recipe = this.recipe.toDomain(),
        ingredients = this.ingredients
            .sortedBy { it.position }
            .map { it.toDomain() },
        steps = this.steps
            .sortedBy { it.position }
            .map { it.toDomain() },
        mealTypes = this.mealTypes
            .map { MealType.valueOf(it.mealType) }
            .toSet(),
        dietaryPreferences = this.dietaryPreferences
            .map { DietaryPreference.valueOf(it.dietaryPreference) }
            .toSet(),
        allergens = this.allergens
            .map { Allergy.valueOf(it.allergen) }
            .toSet()
    )
}
