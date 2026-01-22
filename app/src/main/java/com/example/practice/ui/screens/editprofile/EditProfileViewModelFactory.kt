package com.example.practice.ui.screens.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase

class EditProfileViewModelFactory(
    private val getUserProfile: GetUserProfileUseCase,
    private val updateUserProfile: SetUserProfileUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditProfileViewModel(
                getUserProfile = getUserProfile,
                updateUserProfile = updateUserProfile
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}