package com.example.practice.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.practice.App
import com.example.practice.data.datastore.NotificationSettingsDataStore
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.domain.usecase.NotificationSettingsUseCase

val Context.userProfileDataStore: UserProfileDataStore
    get() = (applicationContext as App).userProfileDataStore

private val Context.notificationSettingsPreferences: DataStore<Preferences> by preferencesDataStore(
    name = "notification_settings"
)

fun provideNotificationSettingsUseCase(context: Context): NotificationSettingsUseCase {
    val dataStore = NotificationSettingsDataStore(context.notificationSettingsPreferences)
    return NotificationSettingsUseCase(dataStore)
}