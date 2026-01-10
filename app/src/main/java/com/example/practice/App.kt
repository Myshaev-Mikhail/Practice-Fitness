package com.example.practice

import android.app.Application
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.practice.data.datastore.UserProfileDataStore
import java.io.File

class App : Application() {

    val userProfileDataStore: UserProfileDataStore by lazy {
        UserProfileDataStore(
            PreferenceDataStoreFactory.create(
                produceFile = {
                    File(filesDir, "user_profile.preferences_pb")
                }
            )
        )
    }
}