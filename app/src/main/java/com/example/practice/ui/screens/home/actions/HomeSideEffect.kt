package com.example.practice.ui.screens.home.actions

sealed class HomeSideEffect {
    data object ShowSearchScreen : HomeSideEffect()
    data object ShowNotificationScreen : HomeSideEffect()
    data object ShowProfileScreen : HomeSideEffect()
    data object ShowProgressTrackingScreen : HomeSideEffect()
    data object ShowNutritionScreen : HomeSideEffect()
    data object ShowCommunityScreen : HomeSideEffect()
    data object ShowWorkoutSeeAll : HomeSideEffect()
    data object Empty : HomeSideEffect()
}