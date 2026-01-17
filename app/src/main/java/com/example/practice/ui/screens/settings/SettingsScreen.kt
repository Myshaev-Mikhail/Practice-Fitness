package com.example.practice.ui.screens.settings

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.settings.intents.SettingsAction
import com.example.practice.ui.screens.settings.intents.SettingsSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.ProfileMenuItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.Profile
import io.github.composegears.valkyrie.Telegram

@Composable
fun SettingsScreen(
    navController: NavController
) {
    val viewModel: SettingsViewModel = viewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is SettingsSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowNavigateNotification -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowNavigateTheme -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }
        is SettingsSideEffect.ShowNavigateDelProfile -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
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
                            viewModel.uiAction(SettingsAction.NavigateBack)
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
                        viewModel.uiAction(SettingsAction.NavigateNotification)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Telegram),
                    title = "Theme Setting",
                    onClick = {
                        viewModel.uiAction(SettingsAction.NavigateTheme)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Profile),
                    title = "Delete Account",
                    onClick = {
                        viewModel.uiAction(SettingsAction.NavigateDelProfile)
                    }
                )
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}