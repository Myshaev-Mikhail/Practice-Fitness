package com.example.practice.ui.screens.workoutrounds.intents

import com.example.practice.domain.models.Workout
import com.example.practice.domain.models.WorkoutBadgeItem

data class WorkoutRoundsState(
    val workout: Workout? = null,
    val visibleItems: List<WorkoutBadgeItem> = emptyList()
)