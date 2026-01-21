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
        dataStore.edit { prefs ->
            prefs[UserProfileKeys.GENDER] = profile.gender.name
            prefs[UserProfileKeys.AGE] = profile.age
            prefs[UserProfileKeys.WEIGHT] = profile.weight
            prefs[UserProfileKeys.HEIGHT] = profile.height
            prefs[UserProfileKeys.ACTIVITY] = profile.activityLevel.name
            prefs[UserProfileKeys.GOAL] = profile.goal.joinToString(",") { it.name }

            prefs[UserProfileKeys.FULL_NAME] = profile.fullName.orEmpty()
            prefs[UserProfileKeys.NICKNAME] = profile.nickname.orEmpty()
            prefs[UserProfileKeys.EMAIL] = profile.email.orEmpty()
            prefs[UserProfileKeys.MOBILE] = profile.mobileNumber.orEmpty()
            prefs[UserProfileKeys.AVATAR_URI] = profile.avatarUri.orEmpty()
        }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }

    val profileFlow: Flow<UserProfile> =
        dataStore.data.map { prefs ->
            val gender = prefs[UserProfileKeys.GENDER]
                ?.let { runCatching { Gender.valueOf(it) }.getOrNull() }
                ?: Gender.MALE

            val goals = prefs[UserProfileKeys.GOAL]
                ?.takeIf { it.isNotBlank() }
                ?.split(",")
                ?.mapNotNull { runCatching { Goal.valueOf(it) }.getOrNull() }
                ?: emptyList()

            val activityLevel = prefs[UserProfileKeys.ACTIVITY]
                ?.let { runCatching { ActivityLevel.valueOf(it) }.getOrNull() }
                ?: ActivityLevel.BEGINNER

            UserProfile(
                gender = gender,
                age = prefs[UserProfileKeys.AGE] ?: 0,
                weight = prefs[UserProfileKeys.WEIGHT] ?: 0f,
                height = prefs[UserProfileKeys.HEIGHT] ?: 0,
                goal = goals,
                activityLevel = activityLevel,
                fullName = prefs[UserProfileKeys.FULL_NAME],
                nickname = prefs[UserProfileKeys.NICKNAME],
                email = prefs[UserProfileKeys.EMAIL],
                mobileNumber = prefs[UserProfileKeys.MOBILE],
                avatarUri = prefs[UserProfileKeys.AVATAR_URI]
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
    val FULL_NAME = stringPreferencesKey("full_name")
    val NICKNAME = stringPreferencesKey("nickname")
    val EMAIL = stringPreferencesKey("email")
    val MOBILE = stringPreferencesKey("mobile")
    val AVATAR_URI = stringPreferencesKey("avatar_uri")
    val FIRST_SETUP_COMPLETED = booleanPreferencesKey("first_setup_completed")
}