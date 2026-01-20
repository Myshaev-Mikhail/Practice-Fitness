package com.example.practice.domain.usecase

import com.example.practice.data.datastore.NotificationSettingsDataStore
import kotlinx.coroutines.flow.first

class NotificationSettingsUseCase(private val dataStore: NotificationSettingsDataStore) {

    val settingsFlow = dataStore.settingsFlow

    suspend fun setGeneral(enabled: Boolean) = dataStore.setGeneral(enabled)

    suspend fun setSound(enabled: Boolean) = dataStore.setSound(enabled)

    suspend fun setVibrate(enabled: Boolean) = dataStore.setVibrate(enabled)

    suspend fun setTime(hour: Int, minute: Int) = dataStore.setNotificationTime(hour, minute)

    suspend fun clear() = dataStore.clear()
}