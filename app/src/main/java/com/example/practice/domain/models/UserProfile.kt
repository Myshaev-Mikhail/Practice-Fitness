package com.example.practice.domain.models

data class UserProfile(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val goal: Goal,
    val activityLevel: ActivityLevel
)

enum class Gender { MALE, FEMALE }
enum class Goal { LOSE_WEIGHT, GAIN_WEIGHT, MUSCLE_MASS_GAIN, SHAPE_BODY, OTHERS }
enum class ActivityLevel { BEGINNER, INTERMEDIATE, ADVANCED }