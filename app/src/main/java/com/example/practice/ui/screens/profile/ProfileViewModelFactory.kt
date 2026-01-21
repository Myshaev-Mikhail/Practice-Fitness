package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetUserProfileUseCase

class ProfileViewModelFactory(
    private val getUserProfile: GetUserProfileUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(getUserProfile) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}