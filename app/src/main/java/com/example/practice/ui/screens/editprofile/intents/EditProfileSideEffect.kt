package com.example.practice.ui.screens.editprofile.intents

sealed class EditProfileSideEffect {
    data object ShowNavigateBack : EditProfileSideEffect()
    object ShowUnsavedChangesDialog : EditProfileSideEffect()
    data object Empty : EditProfileSideEffect()
}