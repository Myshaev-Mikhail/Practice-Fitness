package com.example.practice.ui.screens.signup.actions

sealed class SignUpSideEffect {
    data object Success : SignUpSideEffect()
    data class ShowToast(val text: String) : SignUpSideEffect()
    data object Empty : SignUpSideEffect()
}