package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.Goal
import com.example.practice.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserProfileDataStore(
    private val dataStore: DataStore<Preferences>
) {
    suspend fun saveGender(gender: Gender) {
        dataStore.edit {
            it[UserProfileKeys.GENDER] = gender.name
        }
    }

    suspend fun saveAge(age: Int) {
        dataStore.edit {
            it[UserProfileKeys.AGE] = age
        }
    }

    suspend fun saveWeight(weight: Float) {
        dataStore.edit {
            it[UserProfileKeys.WEIGHT] = weight
        }
    }

    suspend fun saveHeight(height: Int) {
        dataStore.edit {
            it[UserProfileKeys.HEIGHT] = height
        }
    }

    suspend fun saveGoal(goal: Goal) {
        dataStore.edit {
            it[UserProfileKeys.GOAL] = goal.name
        }
    }

    suspend fun saveActivity(level: ActivityLevel) {
        dataStore.edit {
            it[UserProfileKeys.ACTIVITY] = level.name
        }
    }

    val profileFlow: Flow<UserProfile?> =
        dataStore.data.map { prefs ->
            val gender = prefs[UserProfileKeys.GENDER] ?: return@map null

            UserProfile(
                gender = Gender.valueOf(gender),
                age = prefs[UserProfileKeys.AGE] ?: 0,
                weight = prefs[UserProfileKeys.WEIGHT] ?: 0f,
                height = prefs[UserProfileKeys.HEIGHT] ?: 0,
                goal = Goal.valueOf(prefs[UserProfileKeys.GOAL] ?: Goal.OTHERS.name),
                activityLevel = ActivityLevel.valueOf(
                    prefs[UserProfileKeys.ACTIVITY] ?: ActivityLevel.BEGINNER.name
                )
            )
        }
}

object UserProfileKeys {
    val GENDER = stringPreferencesKey("gender")
    val AGE = intPreferencesKey("age")
    val WEIGHT = floatPreferencesKey("weight")
    val HEIGHT = intPreferencesKey("height")
    val GOAL = stringPreferencesKey("goal")
    val ACTIVITY = stringPreferencesKey("activity")
}