package com.example.practice.di

import com.example.practice.domain.usecase.ChangePasswordUseCase
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.GetWorkoutByIdUseCase
import com.example.practice.domain.usecase.GetWorkoutDetailUseCase
import com.example.practice.domain.usecase.GetWorkoutHeaderUseCase
import com.example.practice.domain.usecase.GetWorkoutsByFilterUseCase
import com.example.practice.domain.usecase.GetWorkoutsUseCase
import com.example.practice.domain.usecase.LogInWithEmailUseCase
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.domain.usecase.ResetPasswordUseCase
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.domain.usecase.SignUpUseCase
import com.example.practice.domain.usecase.StepsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LogInWithEmailUseCase(get()) }
    factory { SignUpUseCase(get()) }
    factory { ResetPasswordUseCase(get()) }
    factory { ChangePasswordUseCase(get()) }
    factory { LogInWithGoogleUseCase(get(), get()) }
    factory { NotificationSettingsUseCase(get()) }
    factory { GetUserProfileUseCase(get()) }
    factory { SetUserProfileUseCase(get()) }
    factory { SetFirstSetupUseCase(get()) }
    factory { GetWorkoutsUseCase(get()) }
    factory { GetWorkoutHeaderUseCase() }
    factory { GetWorkoutsByFilterUseCase(get()) }
    factory { GetWorkoutByIdUseCase(get()) }
    factory { GetWorkoutDetailUseCase(get()) }
    factory { StepsUseCase(get(), get()) }
}