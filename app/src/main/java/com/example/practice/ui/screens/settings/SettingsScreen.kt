package com.example.practice.ui.screens.settings

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.settings.actions.SettingsAction
import com.example.practice.ui.screens.settings.actions.SettingsSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.DeleteAccountDialog
import com.example.practice.ui.uikit.components.ProfileMenuItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Key
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.Profile

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel
) {
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current

    var showDeleteDialog by remember { mutableStateOf(false) }

    when (sideEffect) {
        is SettingsSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowNavigateNotification -> {
            navController.navigate(FitnessScreen.NotificationSetting.route)
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowNavigatePassword -> {
            navController.navigate(FitnessScreen.PasswordSetting.route)
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowDeleteProfile -> {
            navController.navigate(FitnessScreen.OnBoarding.route) {
                popUpTo(0)
            }
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowError -> {
            val message = (sideEffect as SettingsSideEffect.ShowError).throwable.message ?: "Unknown error"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.Empty -> {
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
                            viewModel.handleUiAction(SettingsAction.NavigateBack)
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
                        text = "Settings",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.NotificationOff),
                    title = "Notification Setting",
                    onClick = {
                        viewModel.handleUiAction(SettingsAction.NavigateNotification)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Key),
                    title = "Password Setting",
                    onClick = {
                        viewModel.handleUiAction(SettingsAction.NavigatePassword)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Profile),
                    title = "Delete Account",
                    onClick = {
                        showDeleteDialog = true
                    }
                )
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        if (showDeleteDialog) {
            DeleteAccountDialog(
                onCancel = { showDeleteDialog = false },
                onConfirm = {
                    showDeleteDialog = false
                    viewModel.handleUiAction(SettingsAction.DeleteProfile)
                }
            )
        }
    }
}