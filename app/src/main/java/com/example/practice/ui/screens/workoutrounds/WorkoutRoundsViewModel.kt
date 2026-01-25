package com.example.practice.ui.screens.workoutrounds

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsAction
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsSideEffect
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.practice.domain.models.Workout
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase

class WorkoutRoundsViewModel(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase
) : ViewModel() {
    private val uiState = MutableStateFlow(WorkoutRoundsState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutRoundsSideEffect>(WorkoutRoundsSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: WorkoutRoundsAction) {
        when (action) {
            is WorkoutRoundsAction.NavigationNext -> {
                sideEffect.value = WorkoutRoundsSideEffect.ShowNavigationNext
            }
        }
    }

    fun loadWorkout(workoutId: Int) {
        val workout: Workout = getWorkoutByIdUseCase.execute(workoutId)
            ?: return

        uiState.value = WorkoutRoundsState(
            workout = workout,
            visibleItems = workout.rounds
        )
    }

    fun clearSideEffect() {
        sideEffect.value = WorkoutRoundsSideEffect.Empty
    }
}