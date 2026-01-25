package com.example.practice.domain.repository

import com.example.practice.domain.models.Workout
import com.example.practice.domain.models.WorkoutFilter

interface WorkoutRepository {
    fun getAllWorkouts(): List<Workout>

    fun getWorkoutsByFilter(filter: WorkoutFilter): List<Workout>

    fun getWorkoutById(id: Int): Workout?
}