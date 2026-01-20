package com.example.practice.ui.screens.notificationsetting

import android.app.TimePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingAction
import com.example.practice.ui.screens.notificationsetting.intents.NotificationSettingSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.ToggleSwitch
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import java.util.Calendar

@Composable
fun NotificationSettingScreen(
    navController: NavController,
    viewModel: NotificationSettingViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is NotificationSettingSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }
        is NotificationSettingSideEffect.ShowTimePicker -> {
            val context = LocalContext.current
            val calendar = uiState.notificationTime ?: Calendar.getInstance()

            TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, hourOfDay)
                        set(Calendar.MINUTE, minute)
                    }

                    viewModel.uiAction(
                        NotificationSettingAction.SetNotificationTime(
                            time = selectedTime,
                            context = context
                        )
                    )
                    viewModel.clearSideEffect()
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }
        is NotificationSettingSideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.uiAction(NotificationSettingAction.NavigateBack)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Notifications Settings",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ToggleSwitch(
                    title = "General Notification",
                    checked = uiState.generalNotificationEnabled,
                    onCheckedChange = {
                        viewModel.uiAction(NotificationSettingAction.ToggleGeneralNotification(it))
                    }
                )

                ToggleSwitch(
                    title = "Sound",
                    checked = uiState.soundEnabled,
                    onCheckedChange = {
                        viewModel.uiAction(NotificationSettingAction.ToggleSound(it))
                    }
                )

                ToggleSwitch(
                    title = "Vibrate",
                    checked = uiState.vibrateEnabled,
                    onCheckedChange = {
                        viewModel.uiAction(NotificationSettingAction.ToggleVibrate(it))
                    }
                )

                Spacer(Modifier.height(20.dp))
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}