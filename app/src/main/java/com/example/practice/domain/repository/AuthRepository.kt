package com.example.practice.domain.repository

interface AuthRepository {
    suspend fun signUp(
        email: String,
        password: String,
        fullName: String
    ): Result<Unit>

    suspend fun logIn(
        email: String,
        password: String
    ): Result<Unit>

    suspend fun logInWithGoogle(
        idToken: String
    ): Result<Unit>

    suspend fun resetPassword(
        email: String
    ): Result<Unit>

    suspend fun confirmResetPassword(
        oobCode: String,
        newPassword: String
    ): Result<Unit>

    suspend fun changePassword(
        oldPassword: String,
        newPassword: String
    ): Result<Unit>
}