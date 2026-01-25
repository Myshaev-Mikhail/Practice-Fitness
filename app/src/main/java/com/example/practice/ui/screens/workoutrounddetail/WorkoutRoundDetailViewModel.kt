package com.example.practice.ui.screens.workoutrounddetail

import androidx.lifecycle.ViewModel
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase
import com.example.practice.domain.usecase.GetWorkoutDetailUseCase
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailAction
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailSideEffect
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutRoundDetailViewModel(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase,
    private val getWorkoutDetailUseCase: GetWorkoutDetailUseCase
): ViewModel() {
    private val uiState = MutableStateFlow(WorkoutRoundDetailState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutRoundDetailSideEffect>(WorkoutRoundDetailSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: WorkoutRoundDetailAction) {
        when (action) {
            is WorkoutRoundDetailAction.LoadWorkoutDetail -> loadWorkoutDetail(action)
        }
    }

    private fun loadWorkoutDetail(action: WorkoutRoundDetailAction.LoadWorkoutDetail) {
        val workout = getWorkoutByIdUseCase.execute(action.workoutId)
            ?: return

        val detail = getWorkoutDetailUseCase.execute(
            workoutId = action.workoutId,
            badgeId = action.badgeId
        ) ?: return

        uiState.value = WorkoutRoundDetailState(
            imageRes = detail.imageRes,
            title = detail.title,
            description = detail.description,
            time = detail.time,
            rep = detail.rep,
            workout = workout
        )
    }
}