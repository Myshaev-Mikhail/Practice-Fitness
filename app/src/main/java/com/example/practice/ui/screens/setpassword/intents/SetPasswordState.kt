package com.example.practice.ui.screens.setpassword.intents

data class SetPasswordState(
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false
)