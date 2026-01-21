package com.example.practice.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore

class LogInViewModelFactory(
    private val dataStore: UserProfileDataStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogInViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LogInViewModel(dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}