package com.example.practice.data.local.recipes.catalog

import com.example.practice.data.local.recipes.RecipeDao
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class RecipeCatalogImporter(
    private val dataSource: RecipeCatalogAssetDataSource,
    private val recipeDao: RecipeDao
) {
    private val importLock = Mutex()
    private var ready = false

    suspend fun importCatalogIfNeeded() = importLock.withLock {
        if (ready) return@withLock

        val catalog = dataSource.load()
        val recipeIds = catalog.recipes.map { it.recipe.id }.toSet()
        require(recipeIds.isNotEmpty() && recipeIds.size == catalog.recipes.size)
        if (recipeDao.getImportedRecipeIds(catalog.catalogVersion).toSet() != recipeIds) {
            recipeDao.saveRecipes(catalog.toDetails())
        }
        ready = true
    }
}
