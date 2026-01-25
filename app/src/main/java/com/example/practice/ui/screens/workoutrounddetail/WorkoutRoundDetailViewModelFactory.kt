package com.example.practice.ui.screens.workoutrounddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase
import com.example.practice.domain.usecase.GetWorkoutDetailUseCase

class WorkoutRoundDetailViewModelFactory(
    private val getWorkoutByIdUseCase: GetWorkoutByIdUseCase,
    private val getWorkoutDetailUseCase: GetWorkoutDetailUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutRoundDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WorkoutRoundDetailViewModel(
                getWorkoutByIdUseCase = getWorkoutByIdUseCase,
                getWorkoutDetailUseCase = getWorkoutDetailUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}