package com.example.practice.ui.screens.workoutrounddetail.intents

import com.example.practice.ui.screens.workout.intents.Workout

data class WorkoutRoundDetailState(
    val imageRes: Int? = null,
    val title: String = "",
    val description: String = "",
    val time: String = "",
    val rep: String = "",
    val workout: Workout? = null,
)

sealed class WorkoutDetails {
    data class Item(
        val id: Int,
        val imageRes: Int,
        val description: String,
        val time: String,
        val rep: String,
    ) : WorkoutDetails()
}