package com.example.practice.domain.repository

import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeFull
import com.example.practice.domain.models.RecipeType
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun observeRecipes(): Flow<List<RecipeType>>
    suspend fun getRecipesByMealType(mealType: MealType): List<RecipeType>
    suspend fun getRecipeDetails(recipeId: String): RecipeFull?
    suspend fun getAllRecipeDetails(): List<RecipeFull>
}
