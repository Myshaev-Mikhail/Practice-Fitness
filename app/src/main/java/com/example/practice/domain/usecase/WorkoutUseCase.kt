package com.example.practice.domain.usecase

import com.example.practice.R
import com.example.practice.domain.models.Workout
import com.example.practice.domain.models.WorkoutDetails
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.domain.models.WorkoutHeadCardItem
import com.example.practice.domain.repository.WorkoutRepository

class GetWorkoutsUseCase(
    private val repository: WorkoutRepository
) {
    fun execute(): List<Workout> =
        repository.getAllWorkouts()
}

class GetWorkoutHeaderUseCase {
    fun execute(filter: WorkoutFilter): WorkoutHeadCardItem {
        return when (filter) {
            WorkoutFilter.BEGINNER -> WorkoutHeadCardItem(
                badgeText = "dumbbell step up",
                timeText = "12 Minutes",
                caloriesText = "120 Cal",
                mainImage = R.mipmap.woman_working_out_gym_2_1,
                title = "Let's Go Beginner",
                subtitle = "Explore Different Workout Styles"
            )

            WorkoutFilter.INTERMEDIATE -> WorkoutHeadCardItem(
                badgeText = "Intermediate level",
                timeText = "20 Minutes",
                caloriesText = "250 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_2,
                title = "Keep raising your level",
                subtitle = "Explore Intermediate Workouts"
            )

            WorkoutFilter.ADVANCED -> WorkoutHeadCardItem(
                badgeText = "Advanced",
                timeText = "30 Minutes",
                caloriesText = "400 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_5,
                title = "Unlock Your Potential",
                subtitle = "Explore Advanced Fitness Routines"
            )
        }
    }
}

class GetWorkoutsByFilterUseCase(
    private val repository: WorkoutRepository
) {
    fun execute(filter: WorkoutFilter): List<Workout> =
        repository.getWorkoutsByFilter(filter)
}

class GetWorkoutByIdUseCase(
    private val repository: WorkoutRepository
) {
    fun execute(id: Int): Workout? =
        repository.getWorkoutById(id)
}

class GetWorkoutDetailUseCase(
    private val repository: WorkoutRepository
) {
    fun execute(
        workoutId: Int,
        badgeId: Int
    ): WorkoutDetails.Item? {
        val workout = repository.getWorkoutById(workoutId) ?: return null

        return workout.details
            .filterIsInstance<WorkoutDetails.Item>()
            .firstOrNull { it.id == badgeId }
    }
}