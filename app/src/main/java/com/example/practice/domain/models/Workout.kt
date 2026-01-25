package com.example.practice.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Workout(
    val id: Int,
    val filter: WorkoutFilter,
    val title: String,
    val duration: String,
    val calories: String,
    val exercises: String,
    val imageRes: Int,
    val rounds: List<WorkoutBadgeItem>,
    val details: List<WorkoutDetails>
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

sealed class WorkoutDetails {
    data class Item(
        val id: Int,
        val imageRes: Int,
        val title: String,
        val description: String,
        val time: String,
        val rep: String,
    ) : WorkoutDetails()
}

data class WorkoutHeadCardItem (
    val badgeText: String,
    val timeText: String,
    val caloriesText: String,
    val mainImage: Int,
    val title: String,
    val subtitle: String
)

enum class WorkoutFilter {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}