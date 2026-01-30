package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
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
    suspend fun setFirstSetupCompleted() {
        dataStore.edit {
            it[UserProfileKeys.FIRST_SETUP_COMPLETED] = true
        }
    }

    val getFirstSetupCompleted: Flow<Boolean> =
        dataStore.data.map {
            it[UserProfileKeys.FIRST_SETUP_COMPLETED] ?: false
        }

    suspend fun setProfile(profile: UserProfile) {
        dataStore.edit { preferences ->
            preferences[UserProfileKeys.GENDER] = profile.gender.name
            preferences[UserProfileKeys.AGE] = profile.age
            preferences[UserProfileKeys.WEIGHT] = profile.weight
            preferences[UserProfileKeys.HEIGHT] = profile.height
            preferences[UserProfileKeys.ACTIVITY] = profile.activityLevel.name
            preferences[UserProfileKeys.GOAL] = profile.goal.joinToString(",") { it.name }

            preferences[UserProfileKeys.FULL_NAME] = profile.fullName.orEmpty()
            preferences[UserProfileKeys.NICKNAME] = profile.nickname.orEmpty()
            preferences[UserProfileKeys.EMAIL] = profile.email.orEmpty()
            preferences[UserProfileKeys.MOBILE] = profile.mobileNumber.orEmpty()
            preferences[UserProfileKeys.AVATAR_URI] = profile.avatarUri.orEmpty()
        }
    }

    val profileFlow: Flow<UserProfile> =
        dataStore.data.map { preferences ->
            val gender = preferences[UserProfileKeys.GENDER]
                ?.let { runCatching { Gender.valueOf(it) }.getOrNull() }
                ?: Gender.MALE

            val goals = preferences[UserProfileKeys.GOAL]
                ?.takeIf { it.isNotBlank() }
                ?.split(",")
                ?.mapNotNull { runCatching { Goal.valueOf(it) }.getOrNull() }
                ?: emptyList()

            val activityLevel = preferences[UserProfileKeys.ACTIVITY]
                ?.let { runCatching { ActivityLevel.valueOf(it) }.getOrNull() }
                ?: ActivityLevel.BEGINNER

            UserProfile(
                gender = gender,
                age = preferences[UserProfileKeys.AGE] ?: 0,
                weight = preferences[UserProfileKeys.WEIGHT] ?: 0f,
                height = preferences[UserProfileKeys.HEIGHT] ?: 0,
                goal = goals,
                activityLevel = activityLevel,
                fullName = preferences[UserProfileKeys.FULL_NAME],
                nickname = preferences[UserProfileKeys.NICKNAME],
                email = preferences[UserProfileKeys.EMAIL],
                mobileNumber = preferences[UserProfileKeys.MOBILE],
                avatarUri = preferences[UserProfileKeys.AVATAR_URI]
            )
        }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }
}

object UserProfileKeys {
    val GENDER = stringPreferencesKey("gender")
    val AGE = intPreferencesKey("age")
    val WEIGHT = floatPreferencesKey("weight")
    val HEIGHT = intPreferencesKey("height")
    val GOAL = stringPreferencesKey("goal")
    val ACTIVITY = stringPreferencesKey("activity")
    val FULL_NAME = stringPreferencesKey("full_name")
    val NICKNAME = stringPreferencesKey("nickname")
    val EMAIL = stringPreferencesKey("email")
    val MOBILE = stringPreferencesKey("mobile")
    val AVATAR_URI = stringPreferencesKey("avatar_uri")
    val FIRST_SETUP_COMPLETED = booleanPreferencesKey("first_setup_completed")
}