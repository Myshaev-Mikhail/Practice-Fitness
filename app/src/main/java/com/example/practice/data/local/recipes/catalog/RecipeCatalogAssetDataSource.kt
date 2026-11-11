package com.example.practice.data.local.recipes.catalog

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class RecipeCatalogAssetDataSource(
    private val context: Context,
    private val json: Json
) {
    suspend fun load(): RecipeCatalogDto =
        withContext(Dispatchers.IO) {
            context.assets
                .open("recipe_catalog/recipes.json")
                .bufferedReader()
                .use { reader ->
                    json.decodeFromString<RecipeCatalogDto>(
                        reader.readText()
                    )
                }
        }
}