package com.example.practice.ui.screens.setup.intents

sealed class UserProfileSideEffect {
    data object ShowGenderScreen : UserProfileSideEffect()
    data object Empty : UserProfileSideEffect()
}