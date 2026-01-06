package com.example.practice.ui.screens.setpassword.intents

sealed class SetPasswordAction {
    data class PasswordChanged(val value: String) : SetPasswordAction()
    data class ConfirmPasswordChanged(val value: String) : SetPasswordAction()
    data object SubmitClicked : SetPasswordAction()
    data object BackClicked : SetPasswordAction()
}