package com.example.practice.ui.screens.workout.intents

sealed class WorkoutSideEffect {
    data class ShowNavigationNext(
        val filter: WorkoutFilter,
        val workoutId: Int
    ) : WorkoutSideEffect()
    data object Empty : WorkoutSideEffect()
}