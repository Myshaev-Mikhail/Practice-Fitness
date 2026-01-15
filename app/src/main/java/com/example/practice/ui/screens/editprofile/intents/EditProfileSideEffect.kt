package com.example.practice.ui.screens.editprofile.intents

sealed class EditProfileSideEffect {
    data object ShowNavigateBack : EditProfileSideEffect()
    data object Empty : EditProfileSideEffect()
}