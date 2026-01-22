package com.example.practice.ui.screens.passwordsetting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.ChangePasswordUseCase

class PasswordSettingViewModelFactory(
    private val changePasswordUseCase: ChangePasswordUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PasswordSettingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PasswordSettingViewModel(changePasswordUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}