package com.example.practice.ui.screens.workoutrounddetail

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.workout.workouts
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailAction
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailSideEffect
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailState
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutBadgeItem
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

        val badge = workout.rounds
            .filterIsInstance<WorkoutBadgeItem.Item>()
            .firstOrNull { it.id == action.badgeId }
            ?: return

        uiState.value = WorkoutRoundDetailState(
            imageRes = workout.imageRes,
            title = badge.titleText,
            info = "Duration ${badge.subtitleText}, Sets ${badge.trailingTopText}"
        )
    }
}