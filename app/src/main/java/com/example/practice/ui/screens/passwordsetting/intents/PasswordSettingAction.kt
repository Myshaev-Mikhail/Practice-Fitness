package com.example.practice.ui.screens.passwordsetting.intents

sealed class PasswordSettingAction {
    object NavigateBack : PasswordSettingAction()
    data class CurrentPasswordChanged(val value: String) : PasswordSettingAction()
    data object ForgotPasswordClicked : PasswordSettingAction()
    data class NewPasswordChanged(val value: String) : PasswordSettingAction()
    data class ConfirmNewPasswordChanged(val value: String) : PasswordSettingAction()
    object ChangePasswordClicked : PasswordSettingAction()
}