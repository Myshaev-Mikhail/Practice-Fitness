package com.example.practice.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyStepsDao {
    @Upsert
    suspend fun upsertDay(entity: DailyStepsEntity)

    @Query("SELECT * FROM daily_steps WHERE dateStartMillis = :dateStartMillis")
    suspend fun getDay(dateStartMillis: Long): DailyStepsEntity?

    @Query("""
        SELECT * FROM daily_steps
        WHERE dateStartMillis >= :fromMillis AND dateStartMillis < :toMillis
        ORDER BY dateStartMillis ASC
    """)
    fun observeDays(fromMillis: Long, toMillis: Long): Flow<List<DailyStepsEntity>>

    @Query("SELECT * FROM daily_steps ORDER BY dateStartMillis ASC")
    fun observeAllDays(): Flow<List<DailyStepsEntity>>

    @Query("""
        SELECT COALESCE(SUM(steps), 0) FROM daily_steps
        WHERE dateStartMillis >= :fromMillis AND dateStartMillis < :toMillis
    """)
    fun observeStepsSum(fromMillis: Long, toMillis: Long): Flow<Int>

    @Query("SELECT * FROM daily_steps ORDER BY steps DESC, dateStartMillis DESC LIMIT 1")
    fun observeRecordDay(): Flow<DailyStepsEntity?>
}