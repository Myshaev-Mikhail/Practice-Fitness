package com.example.practice.ui.screens.editprofile.actions

sealed class EditProfileSideEffect {
    data object ShowNavigateBack : EditProfileSideEffect()
    object ShowUnsavedChangesDialog : EditProfileSideEffect()
    data object Empty : EditProfileSideEffect()
}