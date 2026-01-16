package com.example.practice.ui.screens.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.editprofile.intents.EditProfileAction
import com.example.practice.ui.screens.editprofile.intents.EditProfileSideEffect
import com.example.practice.ui.screens.editprofile.intents.EditProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val userProfileDataStore: UserProfileDataStore
): ViewModel() {
    private val uiState = MutableStateFlow(EditProfileState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<EditProfileSideEffect>(EditProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        profileData()
    }

    fun uiAction(action: EditProfileAction) {
        when (action) {
            is EditProfileAction.AvatarPicked -> {
                uiState.value = uiState.value.copy(
                    tempAvatarUri = action.uri
                )
            }

            is EditProfileAction.AvatarConfirmed -> {
                uiState.value = uiState.value.copy(
                    avatarUri = action.uri,
                    tempAvatarUri = null
                )
            }

            EditProfileAction.ClearTempAvatar -> {
                uiState.value = uiState.value.copy(
                    tempAvatarUri = null
                )
            }

            is EditProfileAction.FullNameChanged -> {
                uiState.value = uiState.value.copy(
                    fullName = normalizeText(action.value)
                )
            }

            is EditProfileAction.EmailChanged -> {
                uiState.value = uiState.value.copy(
                    email = normalizeText(action.value)
                )
            }

            is EditProfileAction.MobileChanged -> {
                uiState.value = uiState.value.copy(
                    mobileNumber = normalizeText(action.value)
                )
            }

            is EditProfileAction.AgeChanged -> {
                uiState.value = uiState.value.copy(
                    date = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.WeightChanged -> {
                uiState.value = uiState.value.copy(
                    weight = action.value.toFloatOrNull()
                )
            }

            is EditProfileAction.HeightChanged -> {
                uiState.value = uiState.value.copy(
                    height = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.SaveProfile -> {
                saveProfile()
            }

            is EditProfileAction.NavigateBack -> {
                sideEffect.value = EditProfileSideEffect.ShowNavigateBack
            }
        }
    }

    private fun profileData() {
        viewModelScope.launch {
            userProfileDataStore.profileFlow.first().let { profile ->
                uiState.value = EditProfileState(
                    avatarUri = profile.avatarUri,
                    fullName = profile.fullName.orEmpty(),
                    email = profile.email.orEmpty(),
                    mobileNumber = profile.mobileNumber.orEmpty(),
                    date = profile.age,
                    weight = profile.weight,
                    height = profile.height,
                    isProfileValid = true
                )
            }
        }
    }

    private fun saveProfile() {
        viewModelScope.launch {
            val state = uiState.value

            state.fullName?.let {
                userProfileDataStore.setFullName(it)
            }

            state.email?.let {
                userProfileDataStore.setEmail(it)
            }

            state.mobileNumber?.let {
                userProfileDataStore.setMobile(it)
            }

            state.avatarUri?.let {
                userProfileDataStore.setAvatar(it)
            }

            state.date?.let {
                userProfileDataStore.setAge(it)
            }

            state.weight?.let {
                userProfileDataStore.setWeight(it)
            }

            state.height?.let {
                userProfileDataStore.setHeight(it)
            }

            state.avatarUri?.let {
                userProfileDataStore.setAvatar(it)
            }

            sideEffect.value = EditProfileSideEffect.ShowNavigateBack
        }
    }


    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffect.value = EditProfileSideEffect.Empty
    }
}