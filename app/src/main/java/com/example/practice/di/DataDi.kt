package com.example.practice.di

import androidx.room.Room
import com.example.practice.data.datastore.MealPlanDataStore
import com.example.practice.data.datastore.NotificationSettingsDataStore
import com.example.practice.data.datastore.StepCounterDataStore
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.data.local.AppDatabase
import com.example.practice.data.local.DailyStepsDao
import com.example.practice.data.repository.AuthRepositoryImpl
import com.example.practice.data.repository.GoogleAuthRepositoryImpl
import com.example.practice.data.repository.MealPlanRepositoryImpl
import com.example.practice.data.repository.NotificationSettingsRepositoryImpl
import com.example.practice.data.repository.StepsRepositoryImpl
import com.example.practice.data.repository.UserProfileRepositoryImpl
import com.example.practice.data.repository.WorkoutRepositoryImpl
import com.example.practice.domain.repository.AuthRepository
import com.example.practice.domain.repository.GoogleAuthRepository
import com.example.practice.domain.repository.MealPlanRepository
import com.example.practice.domain.repository.NotificationSettingsRepository
import com.example.practice.domain.repository.StepsRepository
import com.example.practice.domain.repository.UserProfileRepository
import com.example.practice.domain.repository.WorkoutRepository
import com.example.practice.extensions.mealPlanPreferences
import com.example.practice.extensions.notificationSettingsPreferences
import com.example.practice.extensions.stepCounterPreferences
import com.example.practice.extensions.userProfileDataStore
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { FirebaseAuth.getInstance() }
    single<UserProfileDataStore> {
        androidContext().userProfileDataStore
    }

    single<NotificationSettingsDataStore> {
        NotificationSettingsDataStore(
            androidContext().notificationSettingsPreferences
        )
    }
    single<StepCounterDataStore> {
        StepCounterDataStore(
            androidContext().stepCounterPreferences
        )
    }
    single<MealPlanDataStore> {
        MealPlanDataStore(
            androidContext().mealPlanPreferences
        )
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
    single<GoogleAuthRepository> {
        GoogleAuthRepositoryImpl()
    }
    single<NotificationSettingsRepository> {
        NotificationSettingsRepositoryImpl(get())
    }
    single<UserProfileRepository> {
        UserProfileRepositoryImpl(get())
    }
    single<WorkoutRepository> {
        WorkoutRepositoryImpl()
    }

    single<AppDatabase> {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "fitness_database"
        ).build()
    }
    single<DailyStepsDao> {
        get<AppDatabase>().dailySteps()
    }
    single<StepsRepository> {
        StepsRepositoryImpl(get(), get())
    }
    single<MealPlanRepository> {
        MealPlanRepositoryImpl(get())
    }
}