package com.example.practice.ui.screens.settings.intents

sealed class SettingsSideEffect {
    data object ShowNavigateBack : SettingsSideEffect()
    data object ShowNavigateNotification : SettingsSideEffect()
    data object ShowNavigateTheme : SettingsSideEffect()
    data object ShowNavigateDelProfile : SettingsSideEffect()
    data object Empty : SettingsSideEffect()
}