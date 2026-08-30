package com.example.practice.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DailyStepsEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun dailySteps(): DailyStepsDao
}