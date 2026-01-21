package com.example.practice.di

import android.content.Context
import com.example.practice.data.repository.UserProfileRepositoryImpl
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.domain.usecase.UpdateUserProfileUseCase
import com.example.practice.extensions.provideNotificationSettingsUseCase
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.screens.editprofile.EditProfileViewModelFactory
import com.example.practice.ui.screens.home.HomeViewModelFactory
import com.example.practice.ui.screens.login.LogInViewModelFactory
import com.example.practice.ui.screens.profile.ProfileViewModelFactory
import com.example.practice.ui.screens.settings.SettingsViewModelFactory
import com.example.practice.ui.screens.setup.SetUpViewModelFactory

object EditProfileDi {
    fun provideEditProfileViewModelFactory(context: Context): EditProfileViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val getProfileUseCase = GetUserProfileUseCase(repository)
        val updateProfileUseCase = UpdateUserProfileUseCase(repository)

        return EditProfileViewModelFactory(
            getUserProfile = getProfileUseCase,
            updateUserProfile = updateProfileUseCase
        )
    }

    fun provideFirstSetupViewModelFactory(context: Context): LogInViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val setFirstSetup = SetFirstSetupUseCase(repository)

        return LogInViewModelFactory(
            setFirstSetup = setFirstSetup
        )
    }

    fun provideSetUpViewModelFactory(context: Context): SetUpViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val updateProfileUseCase = UpdateUserProfileUseCase(repository)
        val setFirstSetupUseCase = SetFirstSetupUseCase(repository)

        return SetUpViewModelFactory(
            updateUserProfile = updateProfileUseCase,
            setFirstSetup = setFirstSetupUseCase
        )
    }

    fun provideHomeViewModelFactory(context: Context): HomeViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val getUserProfile = GetUserProfileUseCase(repository)

        return HomeViewModelFactory(
            getUserProfile = getUserProfile
        )
    }

    fun provideProfileViewModelFactory(context: Context): ProfileViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val getUserProfile = GetUserProfileUseCase(repository)

        return ProfileViewModelFactory(
            getUserProfile = getUserProfile
        )
    }

    fun provideSettingsViewModelFactory(context: Context): SettingsViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val updateProfileUseCase = UpdateUserProfileUseCase(repository)
        val notificationSettingsUseCase = provideNotificationSettingsUseCase(context)

        return SettingsViewModelFactory(
            updateUserProfileUseCase = updateProfileUseCase,
            notificationSettingsUseCase = notificationSettingsUseCase
        )
    }
}