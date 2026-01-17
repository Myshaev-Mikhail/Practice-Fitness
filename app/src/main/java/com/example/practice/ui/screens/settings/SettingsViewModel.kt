package com.example.practice.ui.screens.settings

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.settings.intents.SettingsAction
import com.example.practice.ui.screens.settings.intents.SettingsSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel: ViewModel() {
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
            is SettingsAction.NavigateTheme -> {
                sideEffect.value = SettingsSideEffect.ShowNavigateTheme
            }
            is SettingsAction.NavigateDelProfile -> {
                sideEffect.value = SettingsSideEffect.ShowNavigateDelProfile
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = SettingsSideEffect.Empty
    }
}