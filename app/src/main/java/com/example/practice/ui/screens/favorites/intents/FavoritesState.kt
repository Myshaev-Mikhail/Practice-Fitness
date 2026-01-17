package com.example.practice.ui.screens.favorites.intents

data class FavoritesState(
    val selectedFilter: FavoritesFilter = FavoritesFilter.ALL,
    val allItems: List<FavoritesItem> = emptyList(),
    val visibleItems: List<FavoritesItem> = emptyList()
)

sealed class FavoritesItem {
    data class Workout(
        val id: String,
        val title: String,
        val duration: String,
        val calories: String,
        val exercises: String,
        val imageRes: Int,
        val isFavorite: Boolean
    ) : FavoritesItem()

    data class Article(
        val id: String,
        val title: String,
        val isDescriptor: Boolean,
        val description: String,
        val duration: String,
        val calories: String,
        val imageRes: Int,
    ) : FavoritesItem()
}