package com.example.practice.ui.screens.workout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetWorkoutHeaderUseCase
import com.example.practice.domain.usecase.GetWorkoutsByFilterUseCase
import com.example.practice.domain.usecase.GetWorkoutsUseCase

class WorkoutViewModelFactory(
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val getWorkoutsByFilterUseCase: GetWorkoutsByFilterUseCase,
    private val getWorkoutHeaderUseCase: GetWorkoutHeaderUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WorkoutViewModel(
                getWorkoutsUseCase = getWorkoutsUseCase,
                getWorkoutsByFilterUseCase = getWorkoutsByFilterUseCase,
                getHeaderUseCase = getWorkoutHeaderUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}