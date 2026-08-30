package com.example.practice.data.local

import com.example.practice.domain.models.StepsType

fun StepsType.toEntity() = DailyStepsEntity(
    dateStartMillis = dateStartMillis,
    steps = steps,
    updatedAtMillis = updatedAtMillis
)

fun DailyStepsEntity.toDomain() = StepsType(
    dateStartMillis = dateStartMillis,
    steps = steps,
    updatedAtMillis = updatedAtMillis
)
