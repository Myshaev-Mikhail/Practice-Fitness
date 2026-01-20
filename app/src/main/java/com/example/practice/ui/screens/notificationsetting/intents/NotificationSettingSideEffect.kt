package com.example.practice.ui.screens.notificationsetting.intents

sealed class NotificationSettingSideEffect {
    data object ShowNavigateBack : NotificationSettingSideEffect()
    data object ShowTimePicker : NotificationSettingSideEffect()
    data object Empty : NotificationSettingSideEffect()
}