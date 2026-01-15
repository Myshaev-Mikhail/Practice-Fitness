package com.example.practice.ui.screens.editprofile.intents

data class EditProfileState(
    val avatarUri: String? = null,
    val tempAvatarUri: String? = null,
    val fullName: String? = "",
    val email: String? = "",
    val mobileNumber: String? = null,
    val date: Int? = null,
    val weight: Float? = null,
    val height: Int? = null,
    val isProfileValid: Boolean? = true
)