package com.example.practice.ui.screens.setup.intents

sealed class UserProfileAction {
    data object NextScreen : UserProfileAction()
}