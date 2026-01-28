package com.example.practice.ui.screens.profile.actions

sealed class ProfileSideEffect {
    data object ShowNavigateBack : ProfileSideEffect()
    data object ShowEditProfileScreen : ProfileSideEffect()
    data object ShowFavoritesScreen : ProfileSideEffect()
    data object ShowPrivacyPolicyScreen : ProfileSideEffect()
    data object ShowSettingsScreen : ProfileSideEffect()
    data object ShowHelpScreen : ProfileSideEffect()
    data object ShowLogoutScreen : ProfileSideEffect()
    data class ShowError(val throwable: Throwable) : ProfileSideEffect()
    data object Empty : ProfileSideEffect()
}