package com.example.practice.ui.screens.setup.intents

import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.Goal

data class SetUpState(
    val gender: Gender? = null,
    val age: Int? = null,
    val weight: Float? = null,
    val height: Int? = null,
    val goal: Goal? = null,
    val activityLevel: ActivityLevel? = null,
    val isLoading: Boolean = false
)