package com.example.practice.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase

class SettingsViewModelFactory(
    private val updateUserProfileUseCase: SetUserProfileUseCase,
    private val notificationSettingsUseCase: NotificationSettingsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(
                updateUserProfile = updateUserProfileUseCase,
                notificationSettings = notificationSettingsUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}