package com.example.practice.ui.screens.workout.intents

sealed class WorkoutSideEffect {
    data class ShowNavigationNext(val filter: WorkoutFilter) : WorkoutSideEffect()
    data object Empty : WorkoutSideEffect()
}