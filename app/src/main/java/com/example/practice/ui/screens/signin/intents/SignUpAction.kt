package com.example.practice.ui.screens.signin.intents

sealed class SignUpAction {
    data class EmailChanged(val value: String) : SignUpAction()
    data class PasswordChanged(val value: String) : SignUpAction()
    data class ConfirmPasswordChanged(val value: String) : SignUpAction()
    data object SignUpClicked : SignUpAction()
}
