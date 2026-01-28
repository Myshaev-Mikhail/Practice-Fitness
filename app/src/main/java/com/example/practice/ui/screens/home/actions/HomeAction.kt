package com.example.practice.ui.screens.home.actions

sealed class HomeAction {
    data object Search : HomeAction()
    data object Notification : HomeAction()
    data object Profile : HomeAction()
    data object ProgressTracking : HomeAction()
    data object Nutrition : HomeAction()
    data object Community : HomeAction()
    data object WorkoutSeeAll : HomeAction()
}