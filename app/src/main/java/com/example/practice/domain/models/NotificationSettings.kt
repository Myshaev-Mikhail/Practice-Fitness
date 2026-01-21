package com.example.practice.domain.models

data class NotificationSettings(
    val generalEnabled: Boolean = false,
    val soundEnabled: Boolean = true,
    val vibrateEnabled: Boolean = true,
    val hour: Int = 9,
    val minute: Int = 0
)