package com.example.practice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_steps")
data class DailyStepsEntity(
    @PrimaryKey
    val dateStartMillis: Long,
    val steps: Int,
    val updatedAtMillis: Long
)