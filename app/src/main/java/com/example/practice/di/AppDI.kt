package com.example.practice.di

import com.example.practice.ui.screens.editprofile.EditProfileViewModel
import com.example.practice.ui.screens.favorites.FavoritesViewModel
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordViewModel
import com.example.practice.ui.screens.help.HelpViewModel
import com.example.practice.ui.screens.home.HomeViewModel
import com.example.practice.ui.screens.login.LogInViewModel
import com.example.practice.ui.screens.notificationsetting.NotificationSettingViewModel
import com.example.practice.ui.screens.onbording.OnboardingViewModel
import com.example.practice.ui.screens.passwordsetting.PasswordSettingViewModel
import com.example.practice.ui.screens.privacypolicy.PrivacyPolicyViewModel
import com.example.practice.ui.screens.profile.ProfileViewModel
import com.example.practice.ui.screens.setpassword.SetPasswordViewModel
import com.example.practice.ui.screens.settings.SettingsViewModel
import com.example.practice.ui.screens.setup.SetUpViewModel
import com.example.practice.ui.screens.signup.SignUpViewModel
import com.example.practice.ui.screens.workout.WorkoutViewModel
import com.example.practice.ui.screens.workoutrounddetail.WorkoutRoundDetailViewModel
import com.example.practice.ui.screens.workoutrounds.WorkoutRoundsViewModel
import org.koin.core.module.dsl.*
import org.koin.dsl.module

val appModule = module {
    viewModel<EditProfileViewModel> { EditProfileViewModel(get(), get()) }
    viewModel<FavoritesViewModel> { FavoritesViewModel() }
    viewModel<ForgottenPasswordViewModel> { ForgottenPasswordViewModel(get()) }
    viewModel<HelpViewModel> { HelpViewModel() }
    viewModel<HomeViewModel> { HomeViewModel(get()) }
    viewModel<LogInViewModel> { LogInViewModel(get(), get(), get()) }
    viewModel<NotificationSettingViewModel> { NotificationSettingViewModel(get(), get()) }
    viewModel<OnboardingViewModel> { OnboardingViewModel() }
    viewModel<PasswordSettingViewModel> { PasswordSettingViewModel(get()) }
    viewModel<PrivacyPolicyViewModel> { PrivacyPolicyViewModel() }
    viewModel<ProfileViewModel> { ProfileViewModel(get(), get(), get()) }
    viewModel<SetPasswordViewModel> { params ->
        SetPasswordViewModel(oobCode = params.get(), get())
    }
    viewModel<SettingsViewModel> { SettingsViewModel(get(), get()) }
    viewModel<SetUpViewModel> { SetUpViewModel(get(), get()) }
    viewModel<SignUpViewModel> { SignUpViewModel(get(), get()) }
    viewModel<WorkoutViewModel> { WorkoutViewModel(get(), get(), get()) }
    viewModel<WorkoutRoundDetailViewModel> { WorkoutRoundDetailViewModel(get(), get()) }
    viewModel<WorkoutRoundsViewModel> { WorkoutRoundsViewModel(get()) }
}