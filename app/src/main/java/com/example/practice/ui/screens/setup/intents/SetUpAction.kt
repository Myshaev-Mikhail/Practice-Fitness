package com.example.practice.ui.screens.setup.intents

import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.Goal

sealed class SetUpAction {
    data object StartSetUp : SetUpAction()
    data class GenderSelected(val gender: Gender) : SetUpAction()
    data class AgeEntered(val age: Int) : SetUpAction()
    data class WeightEntered(val weight: Float) : SetUpAction()
    data class HeightEntered(val height: Int) : SetUpAction()
    data class GoalSelected(val goal: Goal) : SetUpAction()
    data class ActivitySelected(val level: ActivityLevel) : SetUpAction()
    data object NavigateBack : SetUpAction()
}