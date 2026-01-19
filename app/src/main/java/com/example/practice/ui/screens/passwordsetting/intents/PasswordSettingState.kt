package com.example.practice.ui.screens.passwordsetting.intents

data class PasswordSettingState(
    val currentPassword: String = "",
    val newPassword: String = "",
    val confirmNewPassword: String = "",
)