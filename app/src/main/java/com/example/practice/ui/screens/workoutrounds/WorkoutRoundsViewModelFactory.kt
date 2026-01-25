package com.example.practice.ui.screens.workoutrounds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase

class WorkoutRoundsViewModelFactory(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutRoundsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WorkoutRoundsViewModel(
                getWorkoutByIdUseCase = getWorkoutByIdUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}