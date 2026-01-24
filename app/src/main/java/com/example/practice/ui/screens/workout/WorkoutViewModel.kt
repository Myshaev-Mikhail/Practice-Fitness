package com.example.practice.ui.screens.workout

import androidx.lifecycle.ViewModel
import com.example.practice.R
import com.example.practice.ui.screens.workout.intents.WorkoutAction
import com.example.practice.ui.screens.workout.intents.WorkoutFilter
import com.example.practice.ui.screens.workout.intents.WorkoutHeadCardItem
import com.example.practice.ui.screens.workout.intents.WorkoutSideEffect
import com.example.practice.ui.screens.workout.intents.WorkoutState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutViewModel: ViewModel() {
    private val uiState = MutableStateFlow(WorkoutState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutSideEffect>(WorkoutSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        loadWorkouts()
    }

    fun uiAction(action: WorkoutAction) {
        when (action) {
            is WorkoutAction.SelectFilter -> {
                applyFilter(action.filter)
            }

            is WorkoutAction.NavigationNext -> {
                sideEffect.value = WorkoutSideEffect.ShowNavigationNext(
                    action.filter,
                    action.workoutId
                )
            }
        }
    }

    private fun headerFor(filter: WorkoutFilter): WorkoutHeadCardItem {
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

    private fun applyFilter(filter: WorkoutFilter) {
        uiState.value = uiState.value.copy(
            selectedFilter = filter,
            visibleWorkouts = uiState.value.workouts.filter { it.filter == filter },
            workoutHeadCardItem = headerFor(filter)
        )
    }

    private fun loadWorkouts() {
        val all = workouts

        uiState.value = uiState.value.copy(
            workouts = all,
            selectedFilter = WorkoutFilter.BEGINNER,
            visibleWorkouts = all.filter { it.filter == WorkoutFilter.BEGINNER },
            workoutHeadCardItem = headerFor(WorkoutFilter.BEGINNER)
        )
    }

    fun clearSideEffect() {
        sideEffect.value = WorkoutSideEffect.Empty
    }
}