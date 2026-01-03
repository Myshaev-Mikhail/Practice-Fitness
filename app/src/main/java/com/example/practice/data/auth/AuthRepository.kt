package com.example.practice.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend fun signUp(email: String, password: String): Result<Unit> =
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun logIn(email: String, password: String): Result<Unit> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            val error = when (e) {
                is FirebaseAuthInvalidCredentialsException,
                is FirebaseAuthInvalidUserException -> AuthError.InvalidEmailOrPassword
                else -> AuthError.Unknown(e.message ?: "Ошибка входа")
            }
            Result.failure(error)
        }
}