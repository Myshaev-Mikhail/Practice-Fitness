package com.example.practice.ui.screens.workout.intents

data class WorkoutState(
    val selectedFilter: WorkoutFilter = WorkoutFilter.BEGINNER,
    val allItems: List<WorkoutCardItem> = emptyList(),
    val visibleItems: List<WorkoutCardItem> = emptyList(),
    val workoutHeadCardItem: WorkoutHeadCardItem? = null
)

sealed class WorkoutCardItem {
    data class Beginner(
        val id: Int,
        val title: String,
        val duration: String,
        val calories: String,
        val exercises: String,
        val imageRes: Int,
        val isFavorite: Boolean
    ) : WorkoutCardItem()

    data class Intermediate(
        val id: Int,
        val title: String,
        val duration: String,
        val calories: String,
        val exercises: String,
        val imageRes: Int,
        val isFavorite: Boolean
    ) : WorkoutCardItem()

    data class Advanced(
        val id: Int,
        val title: String,
        val duration: String,
        val calories: String,
        val exercises: String,
        val imageRes: Int,
        val isFavorite: Boolean
    ) : WorkoutCardItem()
}

data class WorkoutHeadCardItem (
    val badgeText: String,
    val timeText: String,
    val caloriesText: String,
    val mainImage: Int,
    val title: String,
    val subtitle: String
)