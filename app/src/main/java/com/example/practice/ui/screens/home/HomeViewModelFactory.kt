package com.example.practice.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.domain.usecase.GetUserProfileUseCase

class HomeViewModelFactory(
    private val getUserProfile: GetUserProfileUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(getUserProfile) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}