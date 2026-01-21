package com.example.practice.domain.repository

import com.example.practice.domain.models.NotificationSettings
import kotlinx.coroutines.flow.Flow

interface NotificationSettingsRepository {
    fun observeSettings(): Flow<NotificationSettings>
    suspend fun getCurrentSettings(): NotificationSettings

    suspend fun setGeneral(enabled: Boolean)
    suspend fun setSound(enabled: Boolean)
    suspend fun setVibrate(enabled: Boolean)
    suspend fun setTime(hour: Int, minute: Int)
    suspend fun clear()
}