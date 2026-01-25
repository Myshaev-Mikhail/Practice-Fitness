package com.example.practice.ui.screens.workoutrounds.intents

sealed class WorkoutRoundsSideEffect {
    data object ShowNavigationNext : WorkoutRoundsSideEffect()
    data object Empty : WorkoutRoundsSideEffect()
}