package com.example.practice.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.ui.screens.settings.actions.SettingsAction
import com.example.practice.ui.screens.settings.actions.SettingsSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val setUserProfile: SetUserProfileUseCase,
    private val notificationSettings: NotificationSettingsUseCase
): ViewModel() {
    private val sideEffectFlow = MutableStateFlow<SettingsSideEffect>(SettingsSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: SettingsAction) {
        when (action) {
            is SettingsAction.NavigateBack -> {
                sideEffectFlow.value = SettingsSideEffect.ShowNavigateBack
            }
            is SettingsAction.NavigateNotification -> {
                sideEffectFlow.value = SettingsSideEffect.ShowNavigateNotification
            }
            is SettingsAction.NavigatePassword -> {
                sideEffectFlow.value = SettingsSideEffect.ShowNavigatePassword
            }
            is SettingsAction.DeleteProfile -> {
                deleteAccount()
            }
        }
    }

    private fun deleteAccount() {
        viewModelScope.launch {
            try {
                setUserProfile.clear()
                notificationSettings.clear()
                sideEffectFlow.value = SettingsSideEffect.ShowDeleteProfile
            } catch (e: Exception) {
                sideEffectFlow.value = SettingsSideEffect.ShowError(e)
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = SettingsSideEffect.Empty
    }
}