package com.example.practice.data.repository

import com.example.practice.data.datastore.NotificationSettingsDataStore
import com.example.practice.domain.models.NotificationSettings
import com.example.practice.domain.repository.NotificationSettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class NotificationSettingsRepositoryImpl(
    private val dataStore: NotificationSettingsDataStore
) : NotificationSettingsRepository {

    override fun observeSettings(): Flow<NotificationSettings> = dataStore.settingsFlow

    override suspend fun getCurrentSettings(): NotificationSettings = dataStore.settingsFlow.first()

    override suspend fun setGeneral(enabled: Boolean) = dataStore.setGeneral(enabled)
    override suspend fun setSound(enabled: Boolean) = dataStore.setSound(enabled)
    override suspend fun setVibrate(enabled: Boolean) = dataStore.setVibrate(enabled)
    override suspend fun setTime(hour: Int, minute: Int) = dataStore.setTime(hour, minute)
    override suspend fun clear() = dataStore.clear()
}