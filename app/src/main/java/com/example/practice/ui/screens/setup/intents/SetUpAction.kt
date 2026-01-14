package com.example.practice.ui.screens.setup.intents

import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.Goal

sealed class SetUpAction {
    data object StartSetUp : SetUpAction()
    data class GenderSelected(val gender: Gender) : SetUpAction()
    data object ContinueClickedGender : SetUpAction()
    data class AgeEntered(val age: Int) : SetUpAction()
    data class WeightEntered(val weight: Float) : SetUpAction()
    data class HeightEntered(val height: Int) : SetUpAction()
    data class GoalSelected(val goal: Set<Goal>) : SetUpAction()
    data object ContinueClickedGoal : SetUpAction()
    data class ActivitySelected(val level: ActivityLevel) : SetUpAction()
    data object ContinueClickedActivityLevel : SetUpAction()
    data class ProfileChanged(val profile: SetUpProfile) : SetUpAction()
    data object SaveProfile : SetUpAction()
    data object NavigateBack : SetUpAction()
}