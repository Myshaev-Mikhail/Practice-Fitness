package com.example.practice.ui.screens.notificationsetting.actions

import android.content.Context
import java.util.Calendar

sealed class NotificationSettingAction {
    data object NavigateBack : NotificationSettingAction()
    data class ToggleGeneralNotification(val enabled: Boolean) : NotificationSettingAction()
    data class SetNotificationTime(
        val time: Calendar,
        val context: Context
    ) : NotificationSettingAction()
    data class ToggleSound(val enabled: Boolean) : NotificationSettingAction()
    data class ToggleVibrate(val enabled: Boolean) : NotificationSettingAction()
}