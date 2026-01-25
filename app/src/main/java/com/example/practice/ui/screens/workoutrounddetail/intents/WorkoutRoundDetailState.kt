package com.example.practice.ui.screens.workoutrounddetail.intents

import com.example.practice.domain.models.Workout

data class WorkoutRoundDetailState(
    val imageRes: Int? = null,
    val title: String = "",
    val description: String = "",
    val time: String = "",
    val rep: String = "",
    val workout: Workout? = null,
)