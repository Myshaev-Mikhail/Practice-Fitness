package com.example.practice.ui.screens.notificationsetting

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingAction
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingSideEffect
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationSettingViewModel: ViewModel() {
    private val uiState = MutableStateFlow(NotificationSettingState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<NotificationSettingSideEffect>(NotificationSettingSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: NotificationSettingAction) {
        when (action) {
            is NotificationSettingAction.NavigateBack -> {
                sideEffect.value = NotificationSettingSideEffect.ShowNavigateBack
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = NotificationSettingSideEffect.Empty
    }
}