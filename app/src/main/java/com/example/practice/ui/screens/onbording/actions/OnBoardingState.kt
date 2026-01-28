package com.example.practice.ui.screens.onbording.actions

import com.example.practice.ui.screens.onbording.onboardingpage.onboardingPages

data class OnBoardingState(
    val currentPage: Int = 0,
    val totalPages: Int = onboardingPages.size
)