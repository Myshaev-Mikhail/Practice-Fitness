package com.example.practice.ui.screens.setpassword.intents

sealed class SetPasswordSideEffect {
    data object Success : SetPasswordSideEffect()
    data class ShowToast(val message: String) : SetPasswordSideEffect()
    data object NavigateBack : SetPasswordSideEffect()
    data object Empty : SetPasswordSideEffect()
}