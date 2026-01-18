package com.example.practice.ui.screens.notificationsetting.intents

import java.util.Calendar

data class NotificationSettingState(
    val generalNotificationEnabled: Boolean = false,
    val notificationTime: Calendar? = null,
    val soundEnabled: Boolean = true,
    val vibrateEnabled: Boolean = true
)