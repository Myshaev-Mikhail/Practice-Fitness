package com.example.practice.ui.screens.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.ResetPasswordUseCase

class ForgottenPasswordViewModelFactory(
    private val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForgottenPasswordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ForgottenPasswordViewModel(resetPasswordUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}