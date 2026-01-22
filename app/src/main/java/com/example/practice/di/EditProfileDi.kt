package com.example.practice.di

import android.content.Context
import com.example.practice.data.repository.AuthRepositoryImpl
import com.example.practice.data.repository.GoogleAuthRepositoryImpl
import com.example.practice.data.repository.UserProfileRepositoryImpl
import com.example.practice.domain.usecase.ChangePasswordUseCase
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.LogInWithEmailUseCase
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.ResetPasswordUseCase
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.domain.usecase.SignUpUseCase
import com.example.practice.extensions.provideNotificationSettingsUseCase
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.screens.editprofile.EditProfileViewModelFactory
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordViewModelFactory
import com.example.practice.ui.screens.home.HomeViewModelFactory
import com.example.practice.ui.screens.login.LogInViewModelFactory
import com.example.practice.ui.screens.passwordsetting.PasswordSettingViewModelFactory
import com.example.practice.ui.screens.profile.ProfileViewModelFactory
import com.example.practice.ui.screens.settings.SettingsViewModelFactory
import com.example.practice.ui.screens.setup.SetUpViewModelFactory
import com.example.practice.ui.screens.signup.SignUpViewModelFactory

object EditProfileDi {
    fun provideLogInViewModelFactory(context: Context): LogInViewModelFactory {
        val authRepository = AuthRepositoryImpl()
        val googleAuthRepository = GoogleAuthRepositoryImpl(context)

        val userProfileRepository = UserProfileRepositoryImpl(context.userProfileDataStore)
        val logInWithEmailUseCase = LogInWithEmailUseCase(authRepository)

        val logInWithGoogleUseCase = LogInWithGoogleUseCase(
                authRepository = authRepository,
                googleAuthRepository = googleAuthRepository
            )

        val setFirstSetupUseCase = SetFirstSetupUseCase(userProfileRepository)

        return LogInViewModelFactory(
            logInWithEmailUseCase = logInWithEmailUseCase,
            logInWithGoogleUseCase = logInWithGoogleUseCase,
            setFirstSetup = setFirstSetupUseCase
        )
    }

    fun provideSignUpViewModelFactory(context: Context): SignUpViewModelFactory {
        val authRepository = AuthRepositoryImpl()
        val googleAuthRepository = GoogleAuthRepositoryImpl(context)

        val logInWithEmailUseCase = SignUpUseCase(authRepository)

        val logInWithGoogleUseCase = LogInWithGoogleUseCase(
            authRepository = authRepository,
            googleAuthRepository = googleAuthRepository
        )

        return SignUpViewModelFactory(
            signUpWithEmailUseCase = logInWithEmailUseCase,
            logInWithGoogleUseCase = logInWithGoogleUseCase
        )
    }

    fun provideForgottenPasswordViewModelFactory(context: Context): ForgottenPasswordViewModelFactory {
        val authRepository = AuthRepositoryImpl()

        val resetPasswordUseCase = ResetPasswordUseCase(
            authRepository = authRepository,
        )

        return ForgottenPasswordViewModelFactory(
            resetPasswordUseCase = resetPasswordUseCase
        )
    }

    fun providePasswordSettingViewModelFactory(context: Context): PasswordSettingViewModelFactory {
        val authRepository = AuthRepositoryImpl()

        val changePasswordUseCase = ChangePasswordUseCase(
            authRepository = authRepository,
        )

        return PasswordSettingViewModelFactory(
            changePasswordUseCase = changePasswordUseCase
        )
    }

    fun provideEditProfileViewModelFactory(context: Context): EditProfileViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val getProfileUseCase = GetUserProfileUseCase(repository)
        val updateProfileUseCase = SetUserProfileUseCase(repository)

        return EditProfileViewModelFactory(
            getUserProfile = getProfileUseCase,
            updateUserProfile = updateProfileUseCase
        )
    }

    fun provideSetUpViewModelFactory(context: Context): SetUpViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val updateProfileUseCase = SetUserProfileUseCase(repository)
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

        val setUserProfile = SetUserProfileUseCase(repository)
        val notificationSettings = provideNotificationSettingsUseCase(context)

        return ProfileViewModelFactory(
            getUserProfile = getUserProfile,
            setUserProfile = setUserProfile,
            notificationSettings = notificationSettings
        )
    }

    fun provideSettingsViewModelFactory(context: Context): SettingsViewModelFactory {
        val dataStore = context.userProfileDataStore
        val repository = UserProfileRepositoryImpl(dataStore)

        val updateProfileUseCase = SetUserProfileUseCase(repository)
        val notificationSettingsUseCase = provideNotificationSettingsUseCase(context)

        return SettingsViewModelFactory(
            updateUserProfileUseCase = updateProfileUseCase,
            notificationSettingsUseCase = notificationSettingsUseCase
        )
    }
}