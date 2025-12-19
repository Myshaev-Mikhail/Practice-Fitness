package com.example.practice.ui.screens.onbording

import CommunityOn
import NutritionOn
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.practice.R
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.WorkOut

data class OnboardingPage(
    val imageRes: Int,
    val title: String,
    val description: String,
    val icon: ImageVector
)

val onboardingPages = listOf(
    OnboardingPage(R.mipmap.beautiful_young_sporty_man_training_workout_gym, "Start Your Journey Towards A", "More Active Lifestyle", Icons.WorkOut),
    OnboardingPage(R.mipmap.beautiful_young_sporty_man_training_workout_gym, "Start Your Journey Towards", "A More Active Lifestyle", Icons.WorkOut),
    OnboardingPage(R.mipmap.beautiful_young_sporty_woman_training_workout_gym_3, "Find Nutrition Tips That Fit", "Your Lifestyle", NutritionOn),
    OnboardingPage(R.mipmap.beautiful_young_sporty_man_training_workout_gym_3, "A Community For You,", "Challenge Yourself", CommunityOn),
)