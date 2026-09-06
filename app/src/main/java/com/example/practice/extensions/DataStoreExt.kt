package com.example.practice.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.practice.UserProfileApplication
import com.example.practice.data.datastore.NotificationSettingsDataStore
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.data.repository.NotificationSettingsRepositoryImpl
import com.example.practice.domain.usecase.NotificationSettingsUseCase

val Context.userProfileDataStore: UserProfileDataStore
    get() = (applicationContext as UserProfileApplication).userProfileDataStore

val Context.notificationSettingsPreferences: DataStore<Preferences> by preferencesDataStore(
    name = "notification_settings"
)

val Context.stepCounterPreferences: DataStore<Preferences> by preferencesDataStore(
    name = "step_counter"
)

val Context.mealPlanPreferences: DataStore<Preferences> by preferencesDataStore(
    name = "meal_plan"
)

fun provideNotificationSettingsUseCase(context: Context): NotificationSettingsUseCase {
    val dataStore = NotificationSettingsDataStore(context.notificationSettingsPreferences)
    val repository = NotificationSettingsRepositoryImpl(dataStore)
    return NotificationSettingsUseCase(repository)
}