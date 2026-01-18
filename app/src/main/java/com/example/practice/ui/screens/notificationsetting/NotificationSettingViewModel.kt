package com.example.practice.ui.screens.notificationsetting

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingAction
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingSideEffect
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Calendar

class NotificationSettingViewModel(
    private val useCase: NotificationSettingsUseCase,
    private val context: Context
) : ViewModel() {

    private val uiState = MutableStateFlow(NotificationSettingState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<NotificationSettingSideEffect>(NotificationSettingSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        viewModelScope.launch {
            val settings = useCase.settingsFlow.first()
            uiState.value = uiState.value.copy(
                generalNotificationEnabled = settings.generalEnabled,
                soundEnabled = settings.soundEnabled,
                vibrateEnabled = settings.vibrateEnabled,
                notificationTime = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, settings.hour)
                    set(Calendar.MINUTE, settings.minute)
                }
            )
        }
    }

    fun uiAction(action: NotificationSettingAction) {
        when (action) {
            NotificationSettingAction.NavigateBack -> {
                sideEffect.value = NotificationSettingSideEffect.ShowNavigateBack
            }

            is NotificationSettingAction.ToggleGeneralNotification -> {
                val enabled = action.enabled
                uiState.value = uiState.value.copy(generalNotificationEnabled = enabled)

                viewModelScope.launch {
                    useCase.setGeneral(enabled)
                    if (enabled) {
                        val time = uiState.value.notificationTime ?: Calendar.getInstance()
                        NotificationReceiver.scheduleNextWorker(
                            context = context.applicationContext,
                            hour = time.get(Calendar.HOUR_OF_DAY),
                            minute = time.get(Calendar.MINUTE)
                        )
                    }
                }

                if (enabled) sideEffect.value = NotificationSettingSideEffect.ShowTimePicker
            }

            is NotificationSettingAction.SetNotificationTime -> {
                val calendar = action.time
                uiState.value = uiState.value.copy(notificationTime = calendar)

                viewModelScope.launch {
                    useCase.setTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
                    NotificationReceiver.scheduleNextWorker(
                        context = context.applicationContext,
                        hour = calendar.get(Calendar.HOUR_OF_DAY),
                        minute = calendar.get(Calendar.MINUTE)
                    )
                }
            }

            is NotificationSettingAction.ToggleSound -> {
                uiState.value = uiState.value.copy(soundEnabled = action.enabled)
                viewModelScope.launch { useCase.setSound(action.enabled) }
            }

            is NotificationSettingAction.ToggleVibrate -> {
                uiState.value = uiState.value.copy(vibrateEnabled = action.enabled)
                viewModelScope.launch { useCase.setVibrate(action.enabled) }
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = NotificationSettingSideEffect.Empty
    }
}