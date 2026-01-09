package com.example.practice.ui.screens.setup.intents

import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.Goal

data class SetUpState(
    val gender: Gender? = null,
    val age: Int? = null,
    val weight: Float? = null,
    val height: Int? = null,
    val goal: List<Goal>? = null,
    val activityLevel: ActivityLevel? = null,
    val profile: SetUpProfile? = null,
    val isLoading: Boolean = false,
)

data class SetUpProfile(
    val fullName: String? = null,
    val nickname: String? = null,
    val email: String? = null,
    val mobileNumber: String? = null,
    val avatarUri: String? = null
)