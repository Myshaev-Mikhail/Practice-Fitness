package com.example.practice.domain.usecase

import com.example.practice.domain.models.NotificationSettings
import com.example.practice.domain.repository.NotificationSettingsRepository
import kotlinx.coroutines.flow.Flow

class NotificationSettingsUseCase(
    private val repository: NotificationSettingsRepository
) {

    fun observeSettings(): Flow<NotificationSettings> = repository.observeSettings()

    suspend fun setGeneral(enabled: Boolean) = repository.setGeneral(enabled)
    suspend fun setSound(enabled: Boolean) = repository.setSound(enabled)
    suspend fun setVibrate(enabled: Boolean) = repository.setVibrate(enabled)
    suspend fun setTime(hour: Int, minute: Int) = repository.setTime(hour, minute)
    suspend fun clear() = repository.clear()
}