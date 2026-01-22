package com.example.practice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practice.di.EditProfileDi
import com.example.practice.ui.screens.editprofile.EditProfileScreen
import com.example.practice.ui.screens.editprofile.EditProfileViewModel
import com.example.practice.ui.screens.favorites.FavoritesScreen
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordScreen
import com.example.practice.ui.screens.forgotpassword.ForgottenPasswordViewModel
import com.example.practice.ui.screens.help.HelpScreen
import com.example.practice.ui.screens.home.HomeScreen
import com.example.practice.ui.screens.home.HomeViewModel
import com.example.practice.ui.screens.login.LogInScreen
import com.example.practice.ui.screens.login.LogInViewModel
import com.example.practice.ui.screens.notificationsetting.NotificationSettingScreen
import com.example.practice.ui.screens.notificationsetting.NotificationSettingViewModel
import com.example.practice.ui.screens.notificationsetting.NotificationSettingViewModelFactory
import com.example.practice.ui.screens.onbording.OnBoardingScreen
import com.example.practice.ui.screens.passwordsetting.PasswordSettingScreen
import com.example.practice.ui.screens.passwordsetting.PasswordSettingViewModel
import com.example.practice.ui.screens.privacypolicy.PrivacyPolicyScreen
import com.example.practice.ui.screens.profile.ProfileScreen
import com.example.practice.ui.screens.profile.ProfileViewModel
import com.example.practice.ui.screens.setpassword.SetPasswordScreen
import com.example.practice.ui.screens.settings.SettingsScreen
import com.example.practice.ui.screens.settings.SettingsViewModel
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
import com.example.practice.ui.screens.signup.SignUpViewModel

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
            val context = LocalContext.current

            val viewModel: LogInViewModel = viewModel(
                factory = EditProfileDi.provideLogInViewModelFactory(context)
            )

            LogInScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.SignUp.route) {
            val context = LocalContext.current

            val viewModel: SignUpViewModel = viewModel(
                factory = EditProfileDi.provideSignUpViewModelFactory(context)
            )
            SignUpScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.ForgottenPassword.route) {
            val context = LocalContext.current

            val viewModel: ForgottenPasswordViewModel = viewModel(
                factory = EditProfileDi.provideForgottenPasswordViewModelFactory(context)
            )
            ForgottenPasswordScreen(
                navController = navController,
                viewModel = viewModel
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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

            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
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
            val context = LocalContext.current

            val viewModel: SetUpViewModel = viewModel(
                parentEntry,
                factory = EditProfileDi.provideSetUpViewModelFactory(context)
            )

            FillYourProfileScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Home.route) {
            val dataStore = LocalContext.current

            val viewModel: HomeViewModel = viewModel(
                factory = EditProfileDi.provideHomeViewModelFactory(dataStore)
            )
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Profile.route) {
            val context = LocalContext.current

            val viewModel: ProfileViewModel = viewModel(
                factory = EditProfileDi.provideProfileViewModelFactory(context)
            )
            ProfileScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.EditProfile.route) {
            val context = LocalContext.current

            val viewModel: EditProfileViewModel = viewModel(
                factory = EditProfileDi.provideEditProfileViewModelFactory(context)
            )
            EditProfileScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.Favorites.route) {
            FavoritesScreen(
                navController = navController
            )
        }
        composable(FitnessScreen.Settings.route) {
            val context = LocalContext.current

            val viewModel: SettingsViewModel = viewModel(
                factory = EditProfileDi.provideSettingsViewModelFactory(context)
            )

            SettingsScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.NotificationSetting.route) {
            val context = LocalContext.current

            val viewModel: NotificationSettingViewModel = viewModel(
                factory = NotificationSettingViewModelFactory(context)
            )

            NotificationSettingScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(FitnessScreen.PasswordSetting.route) {
            val context = LocalContext.current
            val viewModel: PasswordSettingViewModel = viewModel(
                factory = EditProfileDi.providePasswordSettingViewModelFactory(context)
            )
            PasswordSettingScreen(
                navController = navController,
                viewModel = viewModel
            )
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
    }
}

sealed class FitnessScreen(val route: String) {
    data object OnBoarding : FitnessScreen("onboarding")
    data object LogIn : FitnessScreen("login")
    data object SignUp : FitnessScreen("signup")
    data object ForgottenPassword : FitnessScreen("forgotten_password")

    data object SetPassword : FitnessScreen("set_password?oobCode={oobCode}") {
        fun createRoute(oobCode: String) =
            "set_password?oobCode=$oobCode"
    }

    data object SetUp : FitnessScreen("set_up")
    data object Gender : FitnessScreen("gender")
    data object Age : FitnessScreen("age")
    data object Weight : FitnessScreen("weight")
    data object Height : FitnessScreen("height")
    data object Goal : FitnessScreen("goal")
    data object ActivityLevel : FitnessScreen("activity_level")
    data object FillYourProfile : FitnessScreen("fill_your_profile")

    data object Home : FitnessScreen("home")
    data object Profile : FitnessScreen("profile")
    data object EditProfile : FitnessScreen("edit_profile")
    data object Favorites : FitnessScreen("favorites")
    data object Settings : FitnessScreen("settings")
    data object NotificationSetting : FitnessScreen("notification_setting")
    data object PasswordSetting : FitnessScreen("password_setting")
    data object Help : FitnessScreen("help")
    data object PrivacyPolicy : FitnessScreen("privacy_policy")
}