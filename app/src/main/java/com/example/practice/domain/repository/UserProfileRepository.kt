package com.example.practice.domain.repository

import com.example.practice.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    fun observeProfile(): Flow<UserProfile>

    suspend fun getCurrentFirstSetup(): Boolean
    suspend fun setFirstSetup()

    suspend fun getCurrentProfile(): UserProfile
    suspend fun updateProfile(profile: UserProfile)

    suspend fun clearProfile()
}