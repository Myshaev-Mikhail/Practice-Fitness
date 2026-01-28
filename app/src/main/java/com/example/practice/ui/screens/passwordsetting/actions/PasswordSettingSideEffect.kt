package com.example.practice.ui.screens.passwordsetting.actions

sealed class PasswordSettingSideEffect {
    data object ShowNavigateBack : PasswordSettingSideEffect()
    data object ShowForgottenPasswordScreen : PasswordSettingSideEffect()
    data class ShowToast(val message: String) : PasswordSettingSideEffect()
    data object Empty : PasswordSettingSideEffect()
}