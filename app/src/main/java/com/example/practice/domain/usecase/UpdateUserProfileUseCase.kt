package com.example.practice.domain.usecase

import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.repository.UserProfileRepository

class UpdateUserProfileUseCase(
    private val repository: UserProfileRepository
) {
    suspend operator fun invoke(updated: UserProfile) {
        val current = repository.getCurrentProfile()

        repository.updateProfile(
            current.copy(
                gender = updated.gender,
                age = updated.age,
                weight = updated.weight,
                height = updated.height,
                goal = updated.goal.ifEmpty { current.goal },
                activityLevel = updated.activityLevel,
                fullName = updated.fullName ?: current.fullName,
                nickname = updated.nickname ?: current.nickname,
                email = updated.email ?: current.email,
                mobileNumber = updated.mobileNumber ?: current.mobileNumber,
                avatarUri = updated.avatarUri ?: current.avatarUri
            )
        )
    }

    suspend fun clear() {
        repository.clearProfile()
    }
}