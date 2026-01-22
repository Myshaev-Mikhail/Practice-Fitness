package com.example.practice.domain.usecase

import com.example.practice.domain.repository.AuthRepository
import com.example.practice.domain.repository.GoogleAuthRepository

class LogInWithGoogleUseCase(
    private val authRepository: AuthRepository,
    private val googleAuthRepository: GoogleAuthRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return googleAuthRepository.signIn()
            .fold(
                onSuccess = { token ->
                    authRepository.logInWithGoogle(token)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
    }
}