package com.example.practice.ui.screens.editprofile.intents

sealed class EditProfileAction {
    data object NavigateBack : EditProfileAction()
    data class AvatarPicked(val uri: String) : EditProfileAction()
    data class AvatarConfirmed(val uri: String) : EditProfileAction()
    data object ClearTempAvatar : EditProfileAction()
    data class FullNameChanged(val value: String) : EditProfileAction()
    data class EmailChanged(val value: String) : EditProfileAction()
    data class MobileChanged(val value: String) : EditProfileAction()
    data class AgeChanged(val value: String) : EditProfileAction()
    data class WeightChanged(val value: String) : EditProfileAction()
    data class HeightChanged(val value: String) : EditProfileAction()
    data object SaveProfile : EditProfileAction()
}