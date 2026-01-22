package com.example.practice.domain.usecase

import com.example.practice.domain.repository.AuthRepository

class LogInWithEmailUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<Unit> =
        authRepository.logIn(email, password)
}

class SignUpUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        fullName: String
    ): Result<Unit> =
        authRepository.signUp(email, password, fullName)
}

class ResetPasswordUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String): Result<Unit> =
        authRepository.resetPassword(email)

    suspend fun confirm(
        oobCode: String,
        newPassword: String
    ): Result<Unit> =
        authRepository.confirmResetPassword(oobCode, newPassword)
}

class ChangePasswordUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        oldPassword: String,
        newPassword: String
    ): Result<Unit> =
        authRepository.changePassword(oldPassword, newPassword)
}