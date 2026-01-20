package com.example.practice.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.domain.usecase.NotificationSettingsUseCase

class SettingsViewModelFactory(
    private val userProfileDataStore: UserProfileDataStore,
    private val notificationSettingsUseCase: NotificationSettingsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(
                userProfileDataStore = userProfileDataStore,
                notificationSettingsUseCase = notificationSettingsUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}