package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.data.datastore.UserProfileDataStore

class SetUpViewModelFactory(
    private val dataStore: UserProfileDataStore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SetUpViewModel(dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}