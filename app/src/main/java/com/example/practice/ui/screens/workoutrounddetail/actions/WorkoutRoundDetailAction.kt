package com.example.practice.ui.screens.workoutrounddetail.actions

sealed class WorkoutRoundDetailAction {
    data class LoadWorkoutDetail(
        val workoutId: Int,
        val badgeId: Int
    ) : WorkoutRoundDetailAction()
}