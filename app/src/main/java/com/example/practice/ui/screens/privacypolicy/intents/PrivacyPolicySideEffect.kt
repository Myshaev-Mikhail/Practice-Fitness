package com.example.practice.ui.screens.privacypolicy.intents

sealed class PrivacyPolicySideEffect {
    data object NavigateBack : PrivacyPolicySideEffect()
    data object Empty : PrivacyPolicySideEffect()
}