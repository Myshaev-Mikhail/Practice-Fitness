package com.example.practice.ui.screens.onbording.actions

sealed class OnboardingAction {
    data object NextPage : OnboardingAction()
    data object Skip : OnboardingAction()
    data object Finish : OnboardingAction()
}