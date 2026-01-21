package com.example.practice.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.SetFirstSetupUseCase

class LogInViewModelFactory(
    private val setFirstSetup : SetFirstSetupUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogInViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LogInViewModel(setFirstSetup) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}