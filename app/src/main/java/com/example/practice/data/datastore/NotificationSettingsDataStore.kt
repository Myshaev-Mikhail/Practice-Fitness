package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.practice.domain.models.NotificationSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NotificationSettingsDataStore(private val dataStore: DataStore<Preferences>) {
    val settingsFlow: Flow<NotificationSettings> = dataStore.data.map { preferences ->
        NotificationSettings(
            generalEnabled = preferences[Keys.GENERAL] ?: false,
            soundEnabled = preferences[Keys.SOUND] ?: true,
            vibrateEnabled = preferences[Keys.VIBRATE] ?: true,
            hour = preferences[Keys.HOUR]?.toIntOrNull() ?: 9,
            minute = preferences[Keys.MINUTE]?.toIntOrNull() ?: 0
        )
    }

    suspend fun setGeneral(enabled: Boolean) {
        dataStore.edit { preferences -> preferences[Keys.GENERAL] = enabled }
    }

    suspend fun setSound(enabled: Boolean) {
        dataStore.edit { preferences -> preferences[Keys.SOUND] = enabled }
    }

    suspend fun setVibrate(enabled: Boolean) {
        dataStore.edit { preferences -> preferences[Keys.VIBRATE] = enabled }
    }

    suspend fun setTime(hour: Int, minute: Int) {
        dataStore.edit { preferences ->
            preferences[Keys.HOUR] = hour.toString()
            preferences[Keys.MINUTE] = minute.toString()
        }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }

    private object Keys {
        val GENERAL = booleanPreferencesKey("general_notification")
        val SOUND = booleanPreferencesKey("sound_notification")
        val VIBRATE = booleanPreferencesKey("vibrate_notification")
        val HOUR = stringPreferencesKey("notification_hour")
        val MINUTE = stringPreferencesKey("notification_minute")
    }
}