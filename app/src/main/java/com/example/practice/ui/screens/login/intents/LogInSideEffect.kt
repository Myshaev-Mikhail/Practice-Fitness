package com.example.practice.ui.screens.login.intents

sealed class LogInSideEffect {
    data object Success : LogInSideEffect()
    data class ShowToast(val text: String) : LogInSideEffect()
    data object ShowForgottenPasswordScreen : LogInSideEffect()
    data object Empty : LogInSideEffect()
}