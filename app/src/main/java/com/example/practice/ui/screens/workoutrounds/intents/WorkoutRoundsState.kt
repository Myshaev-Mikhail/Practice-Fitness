package com.example.practice.ui.screens.workoutrounds.intents

import androidx.compose.ui.graphics.vector.ImageVector

data class WorkoutRoundsState(
    val selectedFilter: WorkoutRoundsFilter = WorkoutRoundsFilter.BEGINNER,
    val allItems: List<WorkoutBadgeItem> = emptyList(),
    val visibleItems: List<WorkoutBadgeItem> = emptyList(),
    val workoutHeadCardItem: WorkoutHeadCardItem? = null
)

sealed class WorkoutBadgeItem {
    data class Beginner(
        val id: Int,
        val icon: ImageVector,
        val titleText: String,
        val subtitleIcon: ImageVector,
        val subtitleText: String,
        val trailingTopText: String,
    ) : WorkoutBadgeItem()

    data class Intermediate(
        val id: Int,
        val icon: ImageVector,
        val titleText: String,
        val subtitleIcon: ImageVector,
        val subtitleText: String,
        val trailingTopText: String,
    ) : WorkoutBadgeItem()

    data class Advanced(
        val id: Int,
        val icon: ImageVector,
        val titleText: String,
        val subtitleIcon: ImageVector,
        val subtitleText: String,
        val trailingTopText: String,
    ) : WorkoutBadgeItem()
}

data class WorkoutHeadCardItem (
    val badgeText: String,
    val timeText: String,
    val caloriesText: String,
    val mainImage: Int,
    val title: String,
    val subtitle: String
)