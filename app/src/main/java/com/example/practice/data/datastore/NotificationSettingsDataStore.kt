package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class NotificationSettings(
    val generalEnabled: Boolean = false,
    val soundEnabled: Boolean = true,
    val vibrateEnabled: Boolean = true,
    val hour: Int = 9,
    val minute: Int = 0
)

class NotificationSettingsDataStore(private val dataStore: DataStore<Preferences>) {

    val settingsFlow: Flow<NotificationSettings> = dataStore.data.map { prefs ->
        NotificationSettings(
            generalEnabled = prefs[Keys.GENERAL] ?: false,
            soundEnabled = prefs[Keys.SOUND] ?: true,
            vibrateEnabled = prefs[Keys.VIBRATE] ?: true,
            hour = prefs[Keys.HOUR]?.toIntOrNull() ?: 9,
            minute = prefs[Keys.MINUTE]?.toIntOrNull() ?: 0
        )
    }

    suspend fun setGeneral(enabled: Boolean) = dataStore.edit { it[Keys.GENERAL] = enabled }
    suspend fun setSound(enabled: Boolean) = dataStore.edit { it[Keys.SOUND] = enabled }
    suspend fun setVibrate(enabled: Boolean) = dataStore.edit { it[Keys.VIBRATE] = enabled }
    suspend fun setNotificationTime(hour: Int, minute: Int) = dataStore.edit {
        it[Keys.HOUR] = hour.toString()
        it[Keys.MINUTE] = minute.toString()
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