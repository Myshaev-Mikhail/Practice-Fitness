package com.example.practice.ui.screens.workout.actions

import com.example.practice.domain.models.Workout
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.domain.models.WorkoutHeadCardItem

data class WorkoutState(
    val selectedFilter: WorkoutFilter = WorkoutFilter.BEGINNER,
    val workouts: List<Workout> = emptyList(),
    val visibleWorkouts: List<Workout> = emptyList(),
    val workoutHeadCardItem: WorkoutHeadCardItem? = null
)