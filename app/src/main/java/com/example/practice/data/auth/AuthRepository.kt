package com.example.practice.data.auth

import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend fun signUp(
        email: String,
        password: String,
        fullName: String
    ): Result<Unit> = try {
        val result = auth
            .createUserWithEmailAndPassword(email, password)
            .await()

        val user = result.user
            ?: return Result.failure(Exception("User is null"))

        user.updateProfile(
            userProfileChangeRequest {
                displayName = fullName
            }
        ).await()

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

    suspend fun logInWithGoogle(idToken: String): Result<Unit> =
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun resetPassword(email: String): Result<Unit> {
        return try {
            val actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl("https://fitbody.app/reset")
                .setHandleCodeInApp(true)
                .setAndroidPackageName(
                    "com.example.practice",
                    true,
                    null
                )
                .build()
            auth.sendPasswordResetEmail(email, actionCodeSettings).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun confirmResetPassword(
        oobCode: String,
        newPassword: String
    ): Result<Unit> {
        return try {
            FirebaseAuth.getInstance()
                .confirmPasswordReset(oobCode, newPassword)
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    suspend fun changePassword(oldPassword: String, newPassword: String): Result<Unit> {
        val user = auth.currentUser ?: return Result.failure(Exception("Пользователь не авторизован"))
        val email = user.email ?: return Result.failure(Exception("Email пользователя не найден"))

        return try {
            val credential = EmailAuthProvider.getCredential(email, oldPassword)
            user.reauthenticate(credential).await()

            user.updatePassword(newPassword).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}