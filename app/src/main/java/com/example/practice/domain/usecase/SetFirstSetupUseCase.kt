package com.example.practice.domain.usecase

import com.example.practice.domain.repository.UserProfileRepository

class SetFirstSetupUseCase(
    private val repository: UserProfileRepository
) {
    suspend operator fun invoke() {
        repository.setFirstSetup()
    }
}