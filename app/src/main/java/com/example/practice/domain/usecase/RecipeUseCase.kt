package com.example.practice.domain.usecase

import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeFull
import com.example.practice.domain.models.RecipeType
import com.example.practice.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeUseCase(
    private val repository: RecipeRepository
) {
    fun observeRecipes(): Flow<List<RecipeType>> {
        return repository.observeRecipes()
    }

    suspend fun getRecipesByMealType(mealType: MealType): List<RecipeType> {
        return repository.getRecipesByMealType(mealType = mealType)
    }

    suspend fun getRecipeDetails(recipeId: String): RecipeFull? {
        return repository.getRecipeDetails(recipeId = recipeId)
    }

    suspend fun getAllRecipeDetails(): List<RecipeFull> {
        return repository.getAllRecipeDetails()
    }
}
