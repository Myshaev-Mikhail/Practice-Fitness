package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.home.HomeViewModel

class ProfileViewModelFactory(
    private val userProfileDataStore: UserProfileDataStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(userProfileDataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}