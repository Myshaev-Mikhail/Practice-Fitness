package com.example.practice.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.ui.screens.settings.intents.SettingsAction
import com.example.practice.ui.screens.settings.intents.SettingsSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userProfileDataStore: UserProfileDataStore,
    private val notificationSettingsUseCase: NotificationSettingsUseCase
): ViewModel() {
    private val sideEffect = MutableStateFlow<SettingsSideEffect>(SettingsSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: SettingsAction) {
        when (action) {
            is SettingsAction.NavigateBack -> {
                sideEffect.value = SettingsSideEffect.ShowNavigateBack
            }
            is SettingsAction.NavigateNotification -> {
                sideEffect.value = SettingsSideEffect.ShowNavigateNotification
            }
            is SettingsAction.NavigatePassword -> {
                sideEffect.value = SettingsSideEffect.ShowNavigatePassword
            }
            is SettingsAction.DeleteProfile -> {
                deleteAccount()
            }
        }
    }

    private fun deleteAccount() {
        viewModelScope.launch {
            try {
                userProfileDataStore.clear()
                notificationSettingsUseCase.clear()
                sideEffect.value = SettingsSideEffect.ShowDeleteProfile
            } catch (e: Exception) {
                sideEffect.value = SettingsSideEffect.ShowError(e)
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = SettingsSideEffect.Empty
    }
}