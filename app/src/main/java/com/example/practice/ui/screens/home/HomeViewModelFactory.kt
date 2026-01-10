package com.example.practice.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore

class HomeViewModelFactory(
    private val userProfileDataStore: UserProfileDataStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(userProfileDataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}