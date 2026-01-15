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
import com.example.practice.ui.screens.setup.intents.SetUpProfile
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

    val firstSetupCompletedFlow: Flow<Boolean> =
        dataStore.data.map {
            it[UserProfileKeys.FIRST_SETUP_COMPLETED] ?: false
        }

    suspend fun setGender(gender: Gender) {
        dataStore.edit {
            it[UserProfileKeys.GENDER] = gender.name
        }
    }

    suspend fun setAge(age: Int) {
        dataStore.edit {
            it[UserProfileKeys.AGE] = age
        }
    }

    suspend fun setWeight(weight: Float) {
        dataStore.edit {
            it[UserProfileKeys.WEIGHT] = weight
        }
    }

    suspend fun setHeight(height: Int) {
        dataStore.edit {
            it[UserProfileKeys.HEIGHT] = height
        }
    }

    suspend fun setGoal(goal: List<Goal>) {
        dataStore.edit {
            it[UserProfileKeys.GOAL] = goal.joinToString(",") { it.name }
        }
    }

    suspend fun setActivity(level: ActivityLevel) {
        dataStore.edit {
            it[UserProfileKeys.ACTIVITY] = level.name
        }
    }

    suspend fun setProfile(profile: SetUpProfile) {
        dataStore.edit {
            it[UserProfileKeys.FULL_NAME] = profile.fullName.orEmpty()
            it[UserProfileKeys.NICKNAME] = profile.nickname.orEmpty()
            it[UserProfileKeys.EMAIL] = profile.email.orEmpty()
            it[UserProfileKeys.MOBILE] = profile.mobileNumber.orEmpty()
            it[UserProfileKeys.AVATAR_URI] = profile.avatarUri.orEmpty()
        }
    }

    val profileFlow: Flow<UserProfile> =
        dataStore.data.map { preferences ->
            val gender = preferences[UserProfileKeys.GENDER]?.let { runCatching { Gender.valueOf(it) }.getOrNull() }
                ?: Gender.MALE

            val goalsString = preferences[UserProfileKeys.GOAL] ?: ""
            val goals: List<Goal> =
                if (goalsString.isBlank()) {
                    emptyList()
                } else {
                    goalsString.split(",").mapNotNull { runCatching { Goal.valueOf(it) }.getOrNull() }
                }

            UserProfile(
                gender = gender,
                age = preferences[UserProfileKeys.AGE] ?: 0,
                weight = preferences[UserProfileKeys.WEIGHT] ?: 0f,
                height = preferences[UserProfileKeys.HEIGHT] ?: 0,
                goal = goals,
                activityLevel = preferences[UserProfileKeys.ACTIVITY]?.let { runCatching { ActivityLevel.valueOf(it) }.getOrNull() }
                    ?: ActivityLevel.BEGINNER,
                fullName = preferences[UserProfileKeys.FULL_NAME],
                nickname = preferences[UserProfileKeys.NICKNAME],
                email = preferences[UserProfileKeys.EMAIL],
                mobileNumber = preferences[UserProfileKeys.MOBILE],
                avatarUri = preferences[UserProfileKeys.AVATAR_URI]
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
    val AVATAR_URI = stringPreferencesKey("avatarUri")
    val FIRST_SETUP_COMPLETED = booleanPreferencesKey("first_setup_completed")
}