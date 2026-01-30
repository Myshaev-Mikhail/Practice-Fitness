package com.example.practice.ui.screens.privacypolicy.actions

sealed class PrivacyPolicySideEffect {
    data object NavigateBack : PrivacyPolicySideEffect()
    data object Empty : PrivacyPolicySideEffect()
}