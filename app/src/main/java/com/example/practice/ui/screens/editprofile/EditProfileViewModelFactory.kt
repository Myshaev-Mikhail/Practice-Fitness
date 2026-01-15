package com.example.practice.ui.screens.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore

class EditProfileViewModelFactory(
    private val userProfileDataStore: UserProfileDataStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditProfileViewModel(userProfileDataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}