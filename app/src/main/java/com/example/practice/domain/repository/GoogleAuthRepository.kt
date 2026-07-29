package com.example.practice.domain.repository

import android.content.Context

interface GoogleAuthRepository {
    suspend fun signIn(context: Context): Result<String>
}