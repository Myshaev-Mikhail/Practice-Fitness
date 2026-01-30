package com.example.practice.ui.screens.settings.actions

sealed class SettingsAction {
    data object NavigateBack : SettingsAction()
    data object NavigateNotification : SettingsAction()
    data object NavigatePassword : SettingsAction()
    data object DeleteProfile : SettingsAction()
}