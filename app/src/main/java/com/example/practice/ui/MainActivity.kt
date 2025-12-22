package com.example.practice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practice.ui.screens.onbording.OnboardingScreen
import com.example.practice.ui.uikit.theme.FitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessTheme {
                OnboardingScreen(
                    onFinish = {
                        // TODO
                    }
                )
            }
        }
    }
}