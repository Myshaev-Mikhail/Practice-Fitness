package com.example.practice.ui.screens.notificationsetting.intents

sealed class NotificationSettingSideEffect {
    data object ShowNavigateBack : NotificationSettingSideEffect()
    data object Empty : NotificationSettingSideEffect()
}