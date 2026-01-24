package com.example.practice.ui.screens.workout.intents

import com.example.practice.ui.screens.workoutrounds.intents.WorkoutBadgeItem

data class WorkoutState(
    val selectedFilter: WorkoutFilter = WorkoutFilter.BEGINNER,
    val workouts: List<Workout> = emptyList(),
    val visibleWorkouts: List<Workout> = emptyList(),
    val workoutHeadCardItem: WorkoutHeadCardItem? = null
)

data class WorkoutHeadCardItem (
    val badgeText: String,
    val timeText: String,
    val caloriesText: String,
    val mainImage: Int,
    val title: String,
    val subtitle: String
)

data class Workout(
    val id: Int,
    val filter: WorkoutFilter,
    val title: String,
    val duration: String,
    val calories: String,
    val exercises: String,
    val imageRes: Int,
    val rounds: List<WorkoutBadgeItem>
)