package com.example.practice

import com.example.practice.domain.models.WorkoutFilter

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
    data object ProgressTracking : FitnessScreen("progress_tracking")
    data object Charts : FitnessScreen("charts")
    data object Workout : FitnessScreen("workout")
    data object WorkoutRounds : FitnessScreen("workout_rounds/{filter}/{workoutId}") {
        fun createRoute(filter: WorkoutFilter, workoutId: Int) =
            "workout_rounds/${filter.name}/$workoutId"
    }
    data object WorkoutRoundDetail : FitnessScreen(
        "workout_badge_detail/{workoutId}/{badgeId}"
    ) {
        fun createRoute(workoutId: Int, badgeId: Int) =
            "workout_badge_detail/$workoutId/$badgeId"
    }

    data object YourPlan : FitnessScreen("your_plan")
    data object MealPlanPreferences : FitnessScreen("meal_plan_preferences")
    data object MealPlanGoals : FitnessScreen("meal_plan_goals")
}