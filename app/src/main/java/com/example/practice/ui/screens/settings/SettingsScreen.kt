package com.example.practice.ui.screens.settings

import android.content.Context
import android.content.res.Configuration
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.screens.settings.actions.SettingsAction
import com.example.practice.ui.screens.settings.actions.SettingsSideEffect
import com.example.practice.ui.utils.localizedAppText
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.DeleteAccountDialog
import com.example.practice.ui.uikit.components.LanguageSwitcher
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Key
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.Profile
import io.github.composegears.valkyrie.World
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Composable
fun SettingsScreen(
    navController: NavController
) {
    val viewModel: SettingsViewModel = koinViewModel()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current
    val dataStore = context.userProfileDataStore
    val selectedLanguage by dataStore.languageFlow.collectAsState(initial = "en")
    val coroutineScope = rememberCoroutineScope()
    val localizedContext = remember(context, selectedLanguage) {
        context.createSettingsLocaleContext(selectedLanguage)
    }

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
            Toast.makeText(context, localizedContext.localizedAppText(message), Toast.LENGTH_SHORT).show()
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
                        text = localizedContext.getString(R.string.settings),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                SettingsMenuItem(
                    icon = rememberVectorPainter(Icons.NotificationOff),
                    title = localizedContext.getString(R.string.notification_setting),
                    onClick = {
                        viewModel.handleUiAction(SettingsAction.NavigateNotification)
                    }
                )
                SettingsMenuItem(
                    icon = rememberVectorPainter(Icons.Key),
                    title = localizedContext.getString(R.string.password_setting),
                    onClick = {
                        viewModel.handleUiAction(SettingsAction.NavigatePassword)
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.World),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )

                    Spacer(Modifier.width(16.dp))

                    Text(
                        text = localizedContext.getString(R.string.language),
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    LanguageSwitcher(
                        selectedLanguage = selectedLanguage,
                        onLanguageSelected = { language ->
                            context.applySettingsLocale(language)
                            coroutineScope.launch {
                                dataStore.setLanguage(language)
                            }
                        }
                    )
                }
                SettingsMenuItem(
                    icon = rememberVectorPainter(Icons.Profile),
                    title = localizedContext.getString(R.string.delete_account),
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

@Composable
private fun SettingsMenuItem(
    icon: Painter,
    title: String,
    rotate: Float = 180f,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )

        Spacer(Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall
        )

        Image(
            painter = rememberVectorPainter(Icons.Arrow),
            contentDescription = null,
            modifier = Modifier
                .size(11.dp)
                .rotate(rotate)
        )
    }
}

private fun Context.createSettingsLocaleContext(language: String): Context {
    val configuration = Configuration(resources.configuration).apply {
        setLocale(settingsLocale(language))
    }
    return createConfigurationContext(configuration)
}

private fun Context.applySettingsLocale(language: String) {
    val locale = settingsLocale(language)
    val configuration = Configuration(resources.configuration).apply {
        setLocale(locale)
    }

    Locale.setDefault(locale)
    @Suppress("DEPRECATION")
    resources.updateConfiguration(configuration, resources.displayMetrics)
}

private fun settingsLocale(language: String): Locale = when (language) {
    "ru" -> Locale.Builder()
        .setLanguage("ru")
        .setRegion("RU")
        .build()
    else -> Locale.Builder()
        .setLanguage("en")
        .build()
}
