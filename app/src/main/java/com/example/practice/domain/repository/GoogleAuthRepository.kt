package com.example.practice.domain.repository

interface GoogleAuthRepository {
    suspend fun signIn(): Result<String>
}