package com.example.practice.ui.screens.login.intents

sealed class LogInAction {
    data class EmailChanged(val value: String) : LogInAction()
    data class PasswordChanged(val value: String) : LogInAction()
    data object LogInClicked : LogInAction()
}