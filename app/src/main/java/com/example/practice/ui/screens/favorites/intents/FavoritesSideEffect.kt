package com.example.practice.ui.screens.favorites.intents

sealed class FavoritesSideEffect {
    data object ShowNavigateBack: FavoritesSideEffect()
    data object ShowSearchScreen : FavoritesSideEffect()
    data object ShowNotificationScreen : FavoritesSideEffect()
    data object ShowProfileScreen : FavoritesSideEffect()
    data object Empty: FavoritesSideEffect()
}