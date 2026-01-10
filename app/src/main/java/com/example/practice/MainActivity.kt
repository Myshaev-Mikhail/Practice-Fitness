package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordScreen
import com.example.practice.ui.screens.home.HomeScreen
import com.example.practice.ui.screens.home.HomeViewModel
import com.example.practice.ui.screens.home.HomeViewModelFactory
import com.example.practice.ui.screens.login.LogInScreen
import com.example.practice.ui.screens.onbording.OnBoardingScreen
import com.example.practice.ui.screens.setpassword.SetPasswordScreen
import com.example.practice.ui.screens.setup.ActivityLevelScreen
import com.example.practice.ui.screens.setup.AgeScreen
import com.example.practice.ui.screens.setup.FillYourProfileScreen
import com.example.practice.ui.screens.setup.GenderScreen
import com.example.practice.ui.screens.setup.GoalScreen
import com.example.practice.ui.screens.setup.HeightScreen
import com.example.practice.ui.screens.setup.SetUpScreen
import com.example.practice.ui.screens.setup.SetUpViewModel
import com.example.practice.ui.screens.setup.SetUpViewModelFactory
import com.example.practice.ui.screens.setup.WeightScreen
import com.example.practice.ui.screens.signup.SignUpScreen
import com.example.practice.ui.uikit.theme.FitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FitnessTheme(true) {
                AppEntryPoint()
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    val context = LocalContext.current
    val dataStore = context.userProfileDataStore

    val onboardingCompleted by dataStore
        .firstSetupCompletedFlow
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
        composable(FitnessScreen.ForgottenPassword.route) {
            ForgottenPasswordScreen(
                navController = navController
            )
        }
        composable(
            route = FitnessScreen.SetPassword.route,
            arguments = listOf(
                navArgument("oobCode") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val oobCode = backStackEntry.arguments?.getString("oobCode")!!

            SetPasswordScreen(
                navController = navController,
                oobCode = oobCode
            )
        }
        composable(FitnessScreen.SetUp.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            SetUpScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Age.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            AgeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(FitnessScreen.Gender.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            GenderScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(FitnessScreen.Weight.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            WeightScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Height.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            HeightScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Goal.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            GoalScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.ActivityLevel.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            ActivityLevelScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.FillYourProfile.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(FitnessScreen.SetUp.route)
            }

            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = SetUpViewModelFactory(dataStore)
            )

            FillYourProfileScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Home.route) {
            val dataStore = LocalContext.current.userProfileDataStore

            val viewModel: HomeViewModel = viewModel(
                factory = HomeViewModelFactory(dataStore)
            )
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

sealed class FitnessScreen(val route: String) {
    data object OnBoarding : FitnessScreen("onboarding")
    data object LogIn : FitnessScreen("login")
    data object SignUp : FitnessScreen("signup")
    data object ForgottenPassword : FitnessScreen("forgotten_password")
    data object SetPassword : FitnessScreen("set_password?oobCode={oobCode}") {
        fun createRoute(oobCode: String): String =
            "set_password?oobCode=$oobCode"
    }
    data object SetUp : FitnessScreen("set_up")
    data object Gender : FitnessScreen("gender")
    data object Age : FitnessScreen("age")
    data object Weight : FitnessScreen("weight")
    data object Height : FitnessScreen("height")
    data object Goal : FitnessScreen("goal")
    data object ActivityLevel : FitnessScreen("activity_level")
    data object FillYourProfile : FitnessScreen("fill_your_frofile")
    data object Home : FitnessScreen("home")
}