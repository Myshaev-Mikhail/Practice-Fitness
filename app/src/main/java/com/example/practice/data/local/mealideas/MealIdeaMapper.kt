package com.example.practice.data.local.mealideas

import com.example.practice.domain.models.MealIdea
import com.example.practice.domain.models.MealIdeaRecipe
import com.example.practice.domain.models.MealIdeaTodayState
import com.example.practice.domain.models.MealType

fun MealIdeaDetails.toDomain(): MealIdea {
    return MealIdea(
        id = mealIdea.id,
        totalCalories = mealIdea.totalCalories,
        totalTimeMinutes = mealIdea.totalTimeMinutes,
        selectedDate = mealIdea.selectedDate,
        todayState = if (mealIdea.isTried && mealIdea.selectedDate != null) {
            MealIdeaTodayState.SelectedPastDay
        } else {
            MealIdeaTodayState.NotSelected
        },
        sortOrder = mealIdea.sortOrder,
        createdAtMillis = mealIdea.createdAtMillis,
        recipes = recipes
            .sortedBy { it.position }
            .map { it.toDomain() }
    )
}

fun MealIdeaRecipeEntity.toDomain(): MealIdeaRecipe {
    return MealIdeaRecipe(
        mealIdeaId = mealIdeaId,
        recipeId = recipeId,
        mealType = MealType.valueOf(mealType),
        position = position
    )
}

fun MealIdea.toDetails(): MealIdeaDetails {
    return MealIdeaDetails(
        mealIdea = MealIdeaEntity(
            id = id,
            totalCalories = totalCalories,
            totalTimeMinutes = totalTimeMinutes,
            selectedDate = selectedDate,
            isTried = selectedDate != null || todayState != MealIdeaTodayState.NotSelected,
            sortOrder = sortOrder,
            createdAtMillis = createdAtMillis
        ),
        recipes = recipes.map { it.toEntity() }
    )
}

fun MealIdeaRecipe.toEntity(): MealIdeaRecipeEntity {
    return MealIdeaRecipeEntity(
        mealIdeaId = mealIdeaId,
        recipeId = recipeId,
        mealType = mealType.name,
        position = position
    )
}
