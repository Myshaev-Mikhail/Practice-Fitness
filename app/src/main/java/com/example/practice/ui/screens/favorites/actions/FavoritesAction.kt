package com.example.practice.ui.screens.favorites.actions

sealed class FavoritesAction {
    data class SelectFilter(val filter: FavoritesFilter) : FavoritesAction()
}