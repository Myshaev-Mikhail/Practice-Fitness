package com.example.practice.ui.screens.workoutrounddetail.intents

sealed class WorkoutRoundDetailAction {
    data class LoadWorkoutDetail(
        val workoutId: Int,
        val badgeId: Int
    ) : WorkoutRoundDetailAction()
}