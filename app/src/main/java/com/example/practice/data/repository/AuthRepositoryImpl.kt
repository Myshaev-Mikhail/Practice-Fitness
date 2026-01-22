package com.example.practice.data.repository

import com.example.practice.domain.repository.AuthRepository
import com.google.firebase.auth.*
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

sealed class AuthError: Throwable() {
    data object InvalidEmailOrPassword : AuthError()
    data class Unknown(val errorMessage: String) : AuthError()
}

class AuthRepositoryImpl(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) : AuthRepository {
    override suspend fun signUp(
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

    override suspend fun logIn(
        email: String,
        password: String
    ): Result<Unit> = try {
        auth.signInWithEmailAndPassword(email, password).await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun logInWithGoogle(
        idToken: String
    ): Result<Unit> = try {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun resetPassword(
        email: String
    ): Result<Unit> = try {
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

    override suspend fun confirmResetPassword(
        oobCode: String,
        newPassword: String
    ): Result<Unit> = try {
        auth.confirmPasswordReset(oobCode, newPassword).await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun changePassword(
        oldPassword: String,
        newPassword: String
    ): Result<Unit> {

        val user = auth.currentUser ?: return Result.failure(Exception("User not authorized"))
        val email = user.email ?: return Result.failure(Exception("Email not found"))

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