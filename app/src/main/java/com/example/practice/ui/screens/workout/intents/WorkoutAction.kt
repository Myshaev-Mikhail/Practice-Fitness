package com.example.practice.ui.screens.workout.intents

import com.example.practice.domain.models.WorkoutFilter

sealed class WorkoutAction {
    data class SelectFilter(val filter: WorkoutFilter) : WorkoutAction()
    data class NavigationNext(
        val filter: WorkoutFilter,
        val workoutId: Int
    ) : WorkoutAction()
}