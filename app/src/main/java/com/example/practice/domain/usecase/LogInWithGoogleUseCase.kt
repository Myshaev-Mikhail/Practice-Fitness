package com.example.practice.domain.usecase

import android.content.Context
import com.example.practice.domain.repository.AuthRepository
import com.example.practice.domain.repository.GoogleAuthRepository

class LogInWithGoogleUseCase(
    private val authRepository: AuthRepository,
    private val googleAuthRepository: GoogleAuthRepository
) {
    suspend operator fun invoke(context: Context): Result<Unit> {
        return googleAuthRepository.signIn(context = context)
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