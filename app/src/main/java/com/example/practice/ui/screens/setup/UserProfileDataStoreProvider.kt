package com.example.practice.ui.screens.setup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.practice.data.datastore.UserProfileDataStore

@Composable
fun rememberUserProfileDataStore(): UserProfileDataStore {
    val context = LocalContext.current

    return remember {
        UserProfileDataStore(
            PreferenceDataStoreFactory.create(
                produceFile = {
                    context.filesDir.resolve("user_profile.preferences_pb")
                }
            )
        )
    }
}