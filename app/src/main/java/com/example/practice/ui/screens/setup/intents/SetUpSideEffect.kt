package com.example.practice.ui.screens.setup.intents

sealed class SetUpSideEffect {
    data object NavigateNext : SetUpSideEffect()
    data object NavigateBack : SetUpSideEffect()
    data object ShowGenderScreen : SetUpSideEffect()
    data object ShowProfileValidationError : SetUpSideEffect()
    data object NavigateToHome : SetUpSideEffect()
    data object Empty : SetUpSideEffect()
}