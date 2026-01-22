package com.example.practice.ui.screens.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.SignUpUseCase

class SignUpViewModelFactory (
    private val signUpWithEmailUseCase: SignUpUseCase,
    private val logInWithGoogleUseCase: LogInWithGoogleUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel(
                signUpWithEmailUseCase = signUpWithEmailUseCase,
                logInWithGoogleUseCase = logInWithGoogleUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}