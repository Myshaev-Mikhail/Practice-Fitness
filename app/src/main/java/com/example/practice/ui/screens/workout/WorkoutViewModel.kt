package com.example.practice.ui.screens.workout

import androidx.lifecycle.ViewModel
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.domain.usecase.GetWorkoutHeaderUseCase
import com.example.practice.domain.usecase.GetWorkoutsByFilterUseCase
import com.example.practice.domain.usecase.GetWorkoutsUseCase
import com.example.practice.ui.screens.workout.intents.WorkoutAction
import com.example.practice.ui.screens.workout.intents.WorkoutSideEffect
import com.example.practice.ui.screens.workout.intents.WorkoutState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutViewModel(
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val getWorkoutsByFilterUseCase: GetWorkoutsByFilterUseCase,
    private val getHeaderUseCase: GetWorkoutHeaderUseCase
): ViewModel() {
    private val uiState = MutableStateFlow(WorkoutState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutSideEffect>(WorkoutSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        loadWorkouts(WorkoutFilter.BEGINNER)
    }

    fun uiAction(action: WorkoutAction) {
        when (action) {
            is WorkoutAction.SelectFilter -> {
                loadWorkouts(action.filter)
            }

            is WorkoutAction.NavigationNext -> {
                sideEffect.value = WorkoutSideEffect.ShowNavigationNext(
                    action.filter,
                    action.workoutId
                )
            }
        }
    }

    private fun loadWorkouts(filter: WorkoutFilter) {
        uiState.value = uiState.value.copy(
            selectedFilter = filter,
            visibleWorkouts = getWorkoutsByFilterUseCase.execute(filter),
            workoutHeadCardItem = getHeaderUseCase.execute(filter)
        )
    }

    fun clearSideEffect() {
        sideEffect.value = WorkoutSideEffect.Empty
    }
}