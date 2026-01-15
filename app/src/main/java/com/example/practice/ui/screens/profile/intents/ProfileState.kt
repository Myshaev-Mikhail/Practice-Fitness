package com.example.practice.ui.screens.profile.intents

data class ProfileState(
    val fullName: String? = "",
    val email: String? = "",
    val weight: Float? = null,
    val age: Int? = null,
    val height: Int? = null,
    val avatarUri: String? = null
)