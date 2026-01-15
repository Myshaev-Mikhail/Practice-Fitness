package com.example.practice.ui.screens.profile.intents

sealed class ProfileSideEffect {
    data object ShowNavigateBack : ProfileSideEffect()
    data object ShowEditProfileScreen : ProfileSideEffect()
    data object ShowFavoriteScreen : ProfileSideEffect()
    data object ShowPrivacyPolicyScreen : ProfileSideEffect()
    data object ShowSettingsScreen : ProfileSideEffect()
    data object ShowSupportScreen : ProfileSideEffect()
    data object ShowLogoutScreen : ProfileSideEffect()
    data object Empty : ProfileSideEffect()
}