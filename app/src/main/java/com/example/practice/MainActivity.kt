package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.ui.screens.login.LogInScreen
import com.example.practice.ui.screens.onbording.OnBoardingScreen
import com.example.practice.ui.screens.signup.SignUpScreen
import com.example.practice.ui.uikit.theme.FitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FitnessTheme(true) {
                NavigationApp(
                    startDestination = FitnessScreen.OnBoarding.route
                )
            }
        }
    }
}

@Composable
fun NavigationApp(startDestination: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(FitnessScreen.OnBoarding.route) {
            OnBoardingScreen(
                navController = navController
            )
        }

        composable(FitnessScreen.LogIn.route) {
            LogInScreen(
                navController = navController
            )
        }
        composable(FitnessScreen.SignUp.route) {
            SignUpScreen(
                navController = navController
            )
        }
    }
}

sealed class FitnessScreen(val route: String) {
    data object OnBoarding : FitnessScreen("onboarding")
    data object LogIn : FitnessScreen("login")
    data object SignUp : FitnessScreen("signup")
}