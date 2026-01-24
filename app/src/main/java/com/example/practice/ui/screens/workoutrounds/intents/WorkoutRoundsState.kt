package com.example.practice.ui.screens.workoutrounds.intents

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.practice.ui.screens.workout.intents.Workout

data class WorkoutRoundsState(
    val workout: Workout? = null,
    val visibleItems: List<WorkoutBadgeItem> = emptyList()
)

sealed class WorkoutBadgeItem {
    data class Item(
        val id: Int,
        val icon: ImageVector,
        val titleText: String,
        val subtitleIcon: ImageVector,
        val subtitleText: String,
        val trailingTopText: String,
    ) : WorkoutBadgeItem()
}