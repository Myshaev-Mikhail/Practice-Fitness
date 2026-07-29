package com.example.practice

import android.app.Application
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.di.appModule
import com.example.practice.di.dataModule
import com.example.practice.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.io.File

class UserProfileApplication : Application() {
    val userProfileDataStore: UserProfileDataStore by lazy {
        UserProfileDataStore(
            PreferenceDataStoreFactory.create(
                produceFile = {
                    File(filesDir, "user_profile.preferences_pb")
                }
            )
        )
    }
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@UserProfileApplication)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}