package com.example.practice.data.repository

import com.example.practice.data.datastore.workouts
import com.example.practice.domain.models.Workout
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl: WorkoutRepository {
    override fun getAllWorkouts(): List<Workout> = workouts

    override fun getWorkoutsByFilter(filter: WorkoutFilter): List<Workout> =
        workouts.filter { it.filter == filter }

    override fun getWorkoutById(id: Int): Workout? =
        workouts.firstOrNull { it.id == id }
}