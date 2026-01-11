package com.example.practice.ui.screens.profile.intents

sealed class ProfileAction {
    data object NavigateBack : ProfileAction()
    data object NavigateProfileEditing : ProfileAction()
    data object NavigateFavorite : ProfileAction()
    data object NavigatePrivacyPolicy : ProfileAction()
    data object NavigateSettings : ProfileAction()
    data object NavigateSupport : ProfileAction()
    data object NavigateLogout : ProfileAction()
}