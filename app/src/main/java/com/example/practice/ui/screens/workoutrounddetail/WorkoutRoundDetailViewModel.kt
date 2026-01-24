package com.example.practice.ui.screens.workoutrounddetail

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.workout.workouts
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutDetails
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailAction
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailSideEffect
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutRoundDetailViewModel: ViewModel() {
    private val uiState = MutableStateFlow(WorkoutRoundDetailState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutRoundDetailSideEffect>(WorkoutRoundDetailSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: WorkoutRoundDetailAction) {
        when (action) {
            is WorkoutRoundDetailAction.Load -> load(action)
        }
    }

    private fun load(action: WorkoutRoundDetailAction.Load) {
        val workout = workouts.firstOrNull { it.id == action.workoutId } ?: return

        val detail = workout.details
            .filterIsInstance<WorkoutDetails.Item>()
            .firstOrNull { it.id == action.badgeId }
            ?: return

        uiState.value = WorkoutRoundDetailState(
            imageRes = detail.imageRes,
            title = workout.title,
            description = detail.description,
            time = detail.time,
            rep = detail.rep,
            workout = workout
        )
    }
}