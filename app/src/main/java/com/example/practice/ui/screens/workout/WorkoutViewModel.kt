package com.example.practice.ui.screens.workout

import androidx.lifecycle.ViewModel
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.domain.usecase.GetWorkoutHeaderUseCase
import com.example.practice.domain.usecase.GetWorkoutsByFilterUseCase
import com.example.practice.domain.usecase.GetWorkoutsUseCase
import com.example.practice.ui.screens.workout.actions.WorkoutAction
import com.example.practice.ui.screens.workout.actions.WorkoutSideEffect
import com.example.practice.ui.screens.workout.actions.WorkoutState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutViewModel(
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val getWorkoutsByFilterUseCase: GetWorkoutsByFilterUseCase,
    private val getHeaderUseCase: GetWorkoutHeaderUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(WorkoutState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<WorkoutSideEffect>(WorkoutSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        loadWorkouts(WorkoutFilter.BEGINNER)
    }

    fun handleUiAction(action: WorkoutAction) {
        when (action) {
            is WorkoutAction.SelectFilter -> {
                loadWorkouts(action.filter)
            }

            is WorkoutAction.NavigationNext -> {
                sideEffectFlow.value = WorkoutSideEffect.ShowNavigationNext(
                    action.filter,
                    action.workoutId
                )
            }
        }
    }

    private fun loadWorkouts(filter: WorkoutFilter) {
        uiStateFlow.value = uiStateFlow.value.copy(
            selectedFilter = filter,
            visibleWorkouts = getWorkoutsByFilterUseCase.execute(filter),
            workoutHeadCardItem = getHeaderUseCase.execute(filter)
        )
    }

    fun clearSideEffect() {
        sideEffectFlow.value = WorkoutSideEffect.Empty
    }
}