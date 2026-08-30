package com.example.practice.domain.repository

import com.example.practice.domain.models.StepsRecord
import com.example.practice.domain.models.StepsType
import kotlinx.coroutines.flow.Flow

interface StepsRepository {
    suspend fun saveAndUpdateSteps(steps: StepsType)

    fun getStepsForAPeriod(fromMillis: Long, toMillis: Long): Flow<List<StepsType>>
    fun getStepsSumForAPeriod(fromMillis: Long, toMillis: Long): Flow<Int>
    fun getRecordDay(): Flow<StepsRecord>
    fun getRecordWeek(): Flow<StepsRecord>
    fun getRecordMonth(): Flow<StepsRecord>
    fun getRecordYear(): Flow<StepsRecord>

    fun getPermissionSteps(): Flow<Boolean>
    suspend fun setPermissionSteps(permission: Boolean)
}