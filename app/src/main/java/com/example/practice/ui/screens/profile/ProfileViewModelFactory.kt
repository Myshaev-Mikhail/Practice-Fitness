package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.ui.screens.settings.SettingsViewModel

class ProfileViewModelFactory(
    private val getUserProfile: GetUserProfileUseCase,
    private val setUserProfile: SetUserProfileUseCase,
    private val notificationSettings: NotificationSettingsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(
                getUserProfile = getUserProfile,
                setUserProfile = setUserProfile,
                notificationSettings = notificationSettings
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}