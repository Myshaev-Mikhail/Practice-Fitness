package com.example.practice.domain.models

data class StepsType(
    val dateStartMillis: Long,
    val steps: Int,
    val updatedAtMillis: Long
)

data class StepsRecord(
    val steps: Int = 0,
    val startDateMillis: Long? = null,
    val endDateMillis: Long? = null,
    val distanceMeters: Float = 0f,
    val calories: Int = 0
)

data class StepsActivityStats(
    val steps: Int = 0,
    val distanceMeters: Float = 0f,
    val calories: Int = 0
)

data class StepCounterState(
    val dateStartMillis: Long,
    val sensorBaseSteps: Int,
    val stepsOffset: Int,
    val lastSyncMillis: Long = 0L
)
