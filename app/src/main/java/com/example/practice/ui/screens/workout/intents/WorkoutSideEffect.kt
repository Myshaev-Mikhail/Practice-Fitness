package com.example.practice.ui.screens.workout.intents

import com.example.practice.domain.models.WorkoutFilter

sealed class WorkoutSideEffect {
    data class ShowNavigationNext(
        val filter: WorkoutFilter,
        val workoutId: Int
    ) : WorkoutSideEffect()
    data object Empty : WorkoutSideEffect()
}