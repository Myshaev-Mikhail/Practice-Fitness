package com.example.practice.domain.auth

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.example.practice.R

class GoogleSignInUseCase {
    suspend fun execute(context: Context): Result<String> {
        return try {
            val credentialManager = CredentialManager.create(context)

            val googleOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(context.getString(R.string.default_web_client_id))
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleOption)
                .build()

            val result = credentialManager.getCredential(context, request)
            val credential = result.credential

            val idToken = (credential as? CustomCredential)
                ?.takeIf { it.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL }
                ?.let { GoogleIdTokenCredential.createFrom(it.data).idToken }

            if (idToken != null) Result.success(idToken)
            else Result.failure(Exception("Credential is not Google ID"))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}