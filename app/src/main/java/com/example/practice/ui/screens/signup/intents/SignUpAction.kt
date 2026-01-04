package com.example.practice.ui.screens.signup.intents

sealed class SignUpAction {
    data class EmailChanged(val value: String) : SignUpAction()
    data class PasswordChanged(val value: String) : SignUpAction()
    data class ConfirmPasswordChanged(val value: String) : SignUpAction()
    data object EmailSignUpClicked : SignUpAction()
    data object GoogleLogInClicked : SignUpAction()
}