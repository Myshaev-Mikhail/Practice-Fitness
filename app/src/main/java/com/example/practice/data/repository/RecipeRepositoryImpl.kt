package com.example.practice.data.repository

import com.example.practice.data.local.recipes.RecipeDao
import com.example.practice.data.local.recipes.catalog.RecipeCatalogImporter
import com.example.practice.data.local.recipes.toDomain
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.RecipeFull
import com.example.practice.domain.models.RecipeType
import com.example.practice.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl(
    private val dao: RecipeDao,
    private val catalogImporter: RecipeCatalogImporter
): RecipeRepository {
    override fun observeRecipes(): Flow<List<RecipeType>> = flow {
        catalogImporter.importCatalogIfNeeded()
        emitAll(dao.observeRecipes().map { recipes -> recipes.map { it.toDomain() } })
    }

    override suspend fun getRecipesByMealType(mealType: MealType): List<RecipeType> {
        catalogImporter.importCatalogIfNeeded()
        return dao.getRecipesByMealType(mealType.name)
            .map { it.toDomain() }
    }

    override suspend fun getRecipeDetails(recipeId: String): RecipeFull? {
        catalogImporter.importCatalogIfNeeded()
        return dao.getRecipeDetails(recipeId)?.toDomain()
    }

    override suspend fun getAllRecipeDetails(): List<RecipeFull> {
        catalogImporter.importCatalogIfNeeded()
        return dao.getAllRecipeDetails()
            .map { it.toDomain() }
    }
}
