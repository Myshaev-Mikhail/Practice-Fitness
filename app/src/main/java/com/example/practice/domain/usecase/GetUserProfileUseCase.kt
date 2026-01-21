package com.example.practice.domain.usecase

import com.example.practice.domain.repository.UserProfileRepository

class GetUserProfileUseCase(
    private val repository: UserProfileRepository
) {
    operator fun invoke() = repository.observeProfile()
}