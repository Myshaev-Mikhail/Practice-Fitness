package com.example.practice.ui.screens.workoutrounds

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.workoutrounds.actions.WorkoutRoundsAction
import com.example.practice.ui.screens.workoutrounds.actions.WorkoutRoundsSideEffect
import com.example.practice.ui.screens.workoutrounds.actions.WorkoutRoundsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.practice.domain.models.Workout
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase

class WorkoutRoundsViewModel(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(WorkoutRoundsState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<WorkoutRoundsSideEffect>(WorkoutRoundsSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: WorkoutRoundsAction) {
        when (action) {
            is WorkoutRoundsAction.NavigationNext -> {
                sideEffectFlow.value = WorkoutRoundsSideEffect.ShowNavigationNext
            }
        }
    }

    fun loadWorkout(workoutId: Int) {
        val workout: Workout = getWorkoutByIdUseCase.execute(workoutId)
            ?: return

        uiStateFlow.value = WorkoutRoundsState(
            workout = workout,
            visibleItems = workout.rounds
        )
    }

    fun clearSideEffect() {
        sideEffectFlow.value = WorkoutRoundsSideEffect.Empty
    }
}