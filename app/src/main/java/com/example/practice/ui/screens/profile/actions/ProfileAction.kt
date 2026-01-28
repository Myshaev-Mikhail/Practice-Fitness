package com.example.practice.ui.screens.profile.actions

sealed class ProfileAction {
    data object NavigateBack : ProfileAction()
    data object NavigateProfileEditing : ProfileAction()
    data object NavigateFavorite : ProfileAction()
    data object NavigatePrivacyPolicy : ProfileAction()
    data object NavigateSettings : ProfileAction()
    data object NavigateHelp : ProfileAction()
    data object NavigateLogout : ProfileAction()
}