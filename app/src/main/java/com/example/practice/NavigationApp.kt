package com.example.practice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practice.ui.screens.editprofile.EditProfileScreen
import com.example.practice.ui.screens.favorites.FavoritesScreen
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordScreen
import com.example.practice.ui.screens.help.HelpScreen
import com.example.practice.ui.screens.home.HomeScreen
import com.example.practice.ui.screens.login.LogInScreen
import com.example.practice.ui.screens.notificationsetting.NotificationSettingScreen
import com.example.practice.ui.screens.onbording.OnBoardingScreen
import com.example.practice.ui.screens.passwordsetting.PasswordSettingScreen
import com.example.practice.ui.screens.privacypolicy.PrivacyPolicyScreen
import com.example.practice.ui.screens.profile.ProfileScreen
import com.example.practice.ui.screens.setpassword.SetPasswordScreen
import com.example.practice.ui.screens.settings.SettingsScreen
import com.example.practice.ui.screens.setup.ActivityLevelScreen
import com.example.practice.ui.screens.setup.AgeScreen
import com.example.practice.ui.screens.setup.FillYourProfileScreen
import com.example.practice.ui.screens.setup.GenderScreen
import com.example.practice.ui.screens.setup.GoalScreen
import com.example.practice.ui.screens.setup.HeightScreen
import com.example.practice.ui.screens.setup.SetUpScreen
import com.example.practice.ui.screens.setup.SetUpViewModel
import com.example.practice.ui.screens.setup.WeightScreen
import com.example.practice.ui.screens.signup.SignUpScreen
import com.example.practice.ui.screens.workout.WorkoutScreen
import com.example.practice.ui.screens.workoutrounddetail.WorkoutRoundDetailScreen
import com.example.practice.ui.screens.workoutrounds.WorkoutRoundsScreen
import org.koin.androidx.compose.koinViewModel

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
            LogInScreen(navController = navController)
        }
        composable(FitnessScreen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(FitnessScreen.ForgottenPassword.route) {
            ForgottenPasswordScreen(navController = navController)
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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

            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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
            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
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

            val viewModel: SetUpViewModel = koinViewModel(
                viewModelStoreOwner = parentEntry
            )

            FillYourProfileScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(FitnessScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(FitnessScreen.EditProfile.route) {
            EditProfileScreen(navController = navController)
        }
        composable(FitnessScreen.Favorites.route) {
            FavoritesScreen(
                navController = navController
            )
        }
        composable(FitnessScreen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(FitnessScreen.NotificationSetting.route) {
            NotificationSettingScreen(navController = navController)
        }
        composable(FitnessScreen.PasswordSetting.route) {
            PasswordSettingScreen(navController = navController)
        }
        composable(FitnessScreen.Help.route) {
            HelpScreen(
                navController = navController
            )
        }
        composable(FitnessScreen.PrivacyPolicy.route) {
            PrivacyPolicyScreen(
                navController = navController
            )
        }
        composable(FitnessScreen.Workout.route) {
            WorkoutScreen(navController = navController)
        }
        composable(
            route = FitnessScreen.WorkoutRounds.route,
            arguments = listOf(
                navArgument("filter") { type = NavType.StringType },
                navArgument("workoutId") { type = NavType.IntType }
            )
        ) {
            WorkoutRoundsScreen(navController = navController)
        }
        composable(
            route = FitnessScreen.WorkoutRoundDetail.route,
            arguments = listOf(
                navArgument("workoutId") { type = NavType.IntType },
                navArgument("badgeId") { type = NavType.IntType }
            )
        ) {
            WorkoutRoundDetailScreen(navController = navController)
        }
    }
}