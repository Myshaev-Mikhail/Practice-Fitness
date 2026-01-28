package com.example.practice.ui.screens.settings.actions

sealed class SettingsSideEffect {
    data object ShowNavigateBack : SettingsSideEffect()
    data object ShowNavigateNotification : SettingsSideEffect()
    data object ShowNavigatePassword : SettingsSideEffect()
    data object ShowDeleteProfile : SettingsSideEffect()
    data class ShowError(val throwable: Throwable) : SettingsSideEffect()
    data object Empty : SettingsSideEffect()
}