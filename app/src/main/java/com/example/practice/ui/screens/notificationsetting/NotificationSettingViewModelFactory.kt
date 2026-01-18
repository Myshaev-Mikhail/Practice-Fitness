package com.example.practice.ui.screens.notificationsetting

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.extensions.provideNotificationSettingsUseCase

class NotificationSettingViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotificationSettingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotificationSettingViewModel(
                useCase = provideNotificationSettingsUseCase(context),
                context = context
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}