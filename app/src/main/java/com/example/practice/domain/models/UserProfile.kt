package com.example.practice.domain.models

data class UserProfile(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val goal: List<Goal>,
    val activityLevel: ActivityLevel,
    val fullName: String? = null,
    val nickname: String? = null,
    val email: String? = null,
    val mobileNumber: String? = null,
    val avatarUri: String? = null
)

enum class Gender { MALE, FEMALE }
enum class Goal { LOSE_WEIGHT, GAIN_WEIGHT, MUSCLE_MASS_GAIN, SHAPE_BODY, OTHERS }
enum class ActivityLevel { BEGINNER, INTERMEDIATE, ADVANCED }