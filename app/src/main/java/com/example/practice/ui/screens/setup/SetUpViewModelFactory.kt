package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.UpdateUserProfileUseCase
import com.example.practice.domain.usecase.SetFirstSetupUseCase

class SetUpViewModelFactory(
    private val updateUserProfile: UpdateUserProfileUseCase,
    private val setFirstSetup: SetFirstSetupUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SetUpViewModel(
                updateUserProfile = updateUserProfile,
                setFirstSetup = setFirstSetup) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}