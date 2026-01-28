package com.example.practice.ui.screens.workoutrounddetail

import androidx.lifecycle.ViewModel
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase
import com.example.practice.domain.usecase.GetWorkoutDetailUseCase
import com.example.practice.ui.screens.workoutrounddetail.actions.WorkoutRoundDetailAction
import com.example.practice.ui.screens.workoutrounddetail.actions.WorkoutRoundDetailSideEffect
import com.example.practice.ui.screens.workoutrounddetail.actions.WorkoutRoundDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutRoundDetailViewModel(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase,
    private val getWorkoutDetailUseCase: GetWorkoutDetailUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(WorkoutRoundDetailState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<WorkoutRoundDetailSideEffect>(WorkoutRoundDetailSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: WorkoutRoundDetailAction) {
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

        uiStateFlow.value = WorkoutRoundDetailState(
            imageRes = detail.imageRes,
            title = detail.title,
            description = detail.description,
            time = detail.time,
            rep = detail.rep,
            workout = workout
        )
    }
}