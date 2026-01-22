package com.example.practice.data.repository

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.example.practice.R
import com.example.practice.domain.repository.GoogleAuthRepository
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

class GoogleAuthRepositoryImpl(
    private val context: Context
) : GoogleAuthRepository {
    override suspend fun signIn(): Result<String> = try {

        val credentialManager = CredentialManager.create(context)

        val googleOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(
                context.getString(R.string.default_web_client_id)
            )
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleOption)
            .build()

        val result = credentialManager.getCredential(context, request)
        val credential = result.credential

        val idToken =
            (credential as? CustomCredential)
                ?.takeIf {
                    it.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
                }
                ?.let {
                    GoogleIdTokenCredential
                        .createFrom(it.data)
                        .idToken
                }

        if (idToken != null) {
            Result.success(idToken)
        } else {
            Result.failure(Exception("Google ID token not found"))
        }

    } catch (e: Exception) {
        Result.failure(e)
    }
}