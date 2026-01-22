package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.uikit.theme.FitnessTheme

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

    when (onboardingCompleted) {
        null -> {
            // Splash / Loader
        }
        true -> {
            NavigationApp(startDestination = FitnessScreen.Home.route)
        }
        false -> {
            NavigationApp(startDestination = FitnessScreen.OnBoarding.route)
        }
    }
}