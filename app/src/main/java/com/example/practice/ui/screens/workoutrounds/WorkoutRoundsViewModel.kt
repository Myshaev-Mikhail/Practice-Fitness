package com.example.practice.ui.screens.workoutrounds

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.workout.intents.WorkoutFilter
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsAction
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsSideEffect
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.practice.ui.screens.workout.workouts

class WorkoutRoundsViewModel : ViewModel() {

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

    fun setWorkout(filter: WorkoutFilter, workoutId: Int) {
        val workout = workouts.firstOrNull {
            it.filter == filter && it.id == workoutId
        } ?: return

        uiState.value = uiState.value.copy(
            workout = workout,
            visibleItems = workout.rounds
        )
    }

    fun clearSideEffect() {
        sideEffect.value = WorkoutRoundsSideEffect.Empty
    }
}