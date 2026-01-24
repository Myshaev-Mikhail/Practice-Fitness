package com.example.practice.ui.screens.workoutrounddetail.intents

sealed class WorkoutRoundDetailAction {
    data class Load(
        val workoutId: Int,
        val badgeId: Int
    ) : WorkoutRoundDetailAction()
}