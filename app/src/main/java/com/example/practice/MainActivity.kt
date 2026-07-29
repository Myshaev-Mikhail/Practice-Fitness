package com.example.practice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.uikit.theme.FitnessTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FitnessTheme(true) {
                AppRoot()
            }
        }
    }
}

@Composable
fun AppRoot() {
    val context = LocalContext.current
    val dataStore = context.userProfileDataStore

    val onboardingCompleted by dataStore
        .getFirstSetupCompleted
        .collectAsState(initial = null)
    val language by dataStore
        .languageFlow
        .collectAsState(initial = "en")
    val currentConfiguration = LocalConfiguration.current

    val locale = remember(language) {
        when (language) {
            "ru" -> Locale.Builder()
                .setLanguage("ru")
                .setRegion("RU")
                .build()
            else -> Locale.Builder()
                .setLanguage("en")
                .build()
        }
    }

    SideEffect {
        Locale.setDefault(locale)
    }

    val localizedConfiguration = remember(currentConfiguration, locale) {
        Configuration(currentConfiguration).apply {
            setLocale(locale)
        }
    }

    SideEffect {
        @Suppress("DEPRECATION")
        context.resources.updateConfiguration(
            localizedConfiguration,
            context.resources.displayMetrics
        )
    }

    CompositionLocalProvider(
        LocalConfiguration provides localizedConfiguration
    ) {
        when (onboardingCompleted) {
            null -> {
                // Splash / Loader
            }
            true -> {
                NavigationApp(startDestination = FitnessScreen.Home.route)
            }
            false -> {
                NavigationApp(startDestination = FitnessScreen.LogIn.route)
            }
        }
    }
}
