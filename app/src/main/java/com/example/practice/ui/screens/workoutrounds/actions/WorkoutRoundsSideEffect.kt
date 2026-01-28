package com.example.practice.ui.screens.workoutrounds.actions

sealed class WorkoutRoundsSideEffect {
    data object ShowNavigationNext : WorkoutRoundsSideEffect()
    data object Empty : WorkoutRoundsSideEffect()
}