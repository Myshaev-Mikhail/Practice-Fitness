package com.example.practice.data.repository

import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserProfileRepositoryImpl(
    private val dataStore: UserProfileDataStore
) : UserProfileRepository {

    override fun observeProfile(): Flow<UserProfile> = dataStore.profileFlow

    override suspend fun getCurrentFirstSetup(): Boolean = dataStore.getFirstSetupCompleted.first()

    override suspend fun setFirstSetup() {
        dataStore.setFirstSetupCompleted()
    }

    override suspend fun getCurrentProfile(): UserProfile = dataStore.profileFlow.first()

    override suspend fun updateProfile(profile: UserProfile) {
        dataStore.setProfile(profile)
    }

    override suspend fun clearProfile() = dataStore.clear()
}