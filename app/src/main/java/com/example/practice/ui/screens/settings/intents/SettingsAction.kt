package com.example.practice.ui.screens.settings.intents

sealed class SettingsAction {
    data object NavigateBack : SettingsAction()
    data object NavigateNotification : SettingsAction()
    data object NavigateTheme : SettingsAction()
    data object NavigateDelProfile : SettingsAction()
}