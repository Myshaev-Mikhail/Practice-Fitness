package com.example.practice.ui.screens.login.intents

data class LogInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)