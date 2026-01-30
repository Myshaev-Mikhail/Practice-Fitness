package com.example.practice.ui.screens.forgotpassword.actions

sealed class ForgottenPasswordSideEffect {
    data object Success : ForgottenPasswordSideEffect()
    data class ShowToast(val message: String) : ForgottenPasswordSideEffect()
    data object NavigateBack : ForgottenPasswordSideEffect()
    data object Empty : ForgottenPasswordSideEffect()
}