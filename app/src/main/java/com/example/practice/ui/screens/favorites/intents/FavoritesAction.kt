package com.example.practice.ui.screens.favorites.intents

sealed class FavoritesAction {
    data class SelectFilter(val filter: FavoritesFilter) : FavoritesAction()
}