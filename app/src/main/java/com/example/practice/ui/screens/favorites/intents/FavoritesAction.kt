package com.example.practice.ui.screens.favorites.intents

sealed class FavoritesAction {
    data object NavigateBack: FavoritesAction()
    data object Search : FavoritesAction()
    data object Notification : FavoritesAction()
    data object Profile : FavoritesAction()
    data class SelectFilter(val filter: FavoritesFilter) : FavoritesAction()
}