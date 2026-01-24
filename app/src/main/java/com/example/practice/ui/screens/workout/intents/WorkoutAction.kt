package com.example.practice.ui.screens.workout.intents

sealed class WorkoutAction {
    data class SelectFilter(val filter: WorkoutFilter) : WorkoutAction()
    data class NavigationNext(val filter: WorkoutFilter) : WorkoutAction()
}