package com.example.practice.ui.screens.login.actions

sealed class LogInAction {
    data class EmailChanged(val value: String) : LogInAction()
    data class PasswordChanged(val value: String) : LogInAction()
    data object EmailLogInClicked : LogInAction()
    data object GoogleLogInClicked : LogInAction()
    data object ForgotPasswordClicked : LogInAction()
    data object SignInClicked : LogInAction()
}