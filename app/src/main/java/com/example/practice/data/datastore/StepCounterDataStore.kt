package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import com.example.practice.domain.models.StepCounterState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class StepCounterDataStore(
    private val dataStore: DataStore<Preferences>
) {
    val stateFlow: Flow<StepCounterState> =
        dataStore.data.map { preferences ->
            StepCounterState(
                dateStartMillis = preferences[StepCounterKeys.DATE_START_MILLIS] ?: 0L,
                sensorBaseSteps = preferences[StepCounterKeys.SENSOR_BASE_STEPS] ?: 0,
                stepsOffset = preferences[StepCounterKeys.STEPS_OFFSET] ?: 0,
                lastSyncMillis = preferences[StepCounterKeys.LAST_SYNC_MILLIS] ?: 0L
            )
        }

    suspend fun getState(): StepCounterState = stateFlow.first()

    suspend fun saveState(state: StepCounterState) {
        dataStore.edit { preferences ->
            preferences[StepCounterKeys.DATE_START_MILLIS] = state.dateStartMillis
            preferences[StepCounterKeys.SENSOR_BASE_STEPS] = state.sensorBaseSteps
            preferences[StepCounterKeys.STEPS_OFFSET] = state.stepsOffset
            preferences[StepCounterKeys.LAST_SYNC_MILLIS] = state.lastSyncMillis
        }
    }

    suspend fun setPermissionSteps(permission: Boolean) {
        dataStore.edit {
            it[StepCounterKeys.PERMISSION_STEP] = permission
        }
    }

    val getPermissionSteps: Flow<Boolean> =
        dataStore.data.map {
            it[StepCounterKeys.PERMISSION_STEP] ?: false
        }
}

private object StepCounterKeys {
    val DATE_START_MILLIS = longPreferencesKey("date_start_millis")
    val SENSOR_BASE_STEPS = intPreferencesKey("sensor_base_steps")
    val STEPS_OFFSET = intPreferencesKey("steps_offset")
    val PERMISSION_STEP = booleanPreferencesKey("permission_step")
    val LAST_SYNC_MILLIS = longPreferencesKey("last_sync_millis")
}
