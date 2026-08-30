package com.example.practice.data.repository

import com.example.practice.data.datastore.StepCounterDataStore
import com.example.practice.data.local.DailyStepsDao
import com.example.practice.data.local.DailyStepsEntity
import com.example.practice.data.local.toDomain
import com.example.practice.data.local.toEntity
import com.example.practice.domain.models.StepsRecord
import com.example.practice.domain.models.StepsType
import com.example.practice.domain.repository.StepsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Calendar

class StepsRepositoryImpl(
    private val dao: DailyStepsDao,
    private val dataStore: StepCounterDataStore
) : StepsRepository {
    override suspend fun saveAndUpdateSteps(steps: StepsType) {
        val oldDay = dao.getDay(steps.dateStartMillis)

        val safeSteps = maxOf(
            oldDay?.steps ?: 0,
            steps.steps
        )

        dao.upsertDay(
            steps.copy(steps = safeSteps).toEntity()
        )
    }

    override fun getStepsForAPeriod(fromMillis: Long, toMillis: Long): Flow<List<StepsType>> {
        return dao.observeDays(fromMillis = fromMillis, toMillis = toMillis)
            .map { list -> list.map { it.toDomain() } }
    }

    override fun getStepsSumForAPeriod(fromMillis: Long, toMillis: Long): Flow<Int> {
        return dao.observeStepsSum(fromMillis = fromMillis, toMillis = toMillis)
    }

    override fun getRecordDay(): Flow<StepsRecord> {
        return dao.observeRecordDay()
            .map { entity ->
                entity?.let {
                    StepsRecord(
                        steps = it.steps,
                        startDateMillis = it.dateStartMillis,
                        endDateMillis = getPeriodEndMillis(
                            startMillis = it.dateStartMillis,
                            period = StepsRecordPeriod.DAY
                        )
                    )
                } ?: StepsRecord()
            }
    }

    override fun getRecordWeek(): Flow<StepsRecord> {
        return observeRecordForPeriod(StepsRecordPeriod.WEEK)
    }

    override fun getRecordMonth(): Flow<StepsRecord> {
        return observeRecordForPeriod(StepsRecordPeriod.MONTH)
    }

    override fun getRecordYear(): Flow<StepsRecord> {
        return observeRecordForPeriod(StepsRecordPeriod.YEAR)
    }

    override fun getPermissionSteps(): Flow<Boolean> {
        return dataStore.getPermissionSteps
    }

    override suspend fun setPermissionSteps(permission: Boolean) {
        dataStore.setPermissionSteps(permission)
    }

    private fun observeRecordForPeriod(period: StepsRecordPeriod): Flow<StepsRecord> {
        return dao.observeAllDays()
            .map { days -> days.toRecord(period) }
    }

    private fun List<DailyStepsEntity>.toRecord(period: StepsRecordPeriod): StepsRecord {
        return groupBy { it.getPeriodStartMillis(period) }
            .map { (startMillis, days) ->
                StepsRecord(
                    steps = days.sumOf { it.steps },
                    startDateMillis = startMillis,
                    endDateMillis = getPeriodEndMillis(
                        startMillis = startMillis,
                        period = period
                    )
                )
            }
            .maxWithOrNull(
                compareBy<StepsRecord> { it.steps }
                    .thenBy { it.startDateMillis ?: Long.MIN_VALUE }
            )
            ?: StepsRecord()
    }

    private fun DailyStepsEntity.getPeriodStartMillis(period: StepsRecordPeriod): Long {
        return when (period) {
            StepsRecordPeriod.DAY -> dateStartMillis
            StepsRecordPeriod.WEEK -> getWeekStartMillis(dateStartMillis)
            StepsRecordPeriod.MONTH -> getMonthStartMillis(dateStartMillis)
            StepsRecordPeriod.YEAR -> getYearStartMillis(dateStartMillis)
        }
    }

    private fun getWeekStartMillis(millis: Long): Long {
        return Calendar.getInstance().apply {
            timeInMillis = millis
            firstDayOfWeek = Calendar.MONDAY
            clearTime()
            val daysFromMonday = (get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY + DAYS_IN_WEEK) % DAYS_IN_WEEK
            add(Calendar.DAY_OF_MONTH, -daysFromMonday)
        }.timeInMillis
    }

    private fun getMonthStartMillis(millis: Long): Long {
        return Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.DAY_OF_MONTH, 1)
            clearTime()
        }.timeInMillis
    }

    private fun getYearStartMillis(millis: Long): Long {
        return Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.MONTH, Calendar.JANUARY)
            set(Calendar.DAY_OF_MONTH, 1)
            clearTime()
        }.timeInMillis
    }

    private fun getPeriodEndMillis(startMillis: Long, period: StepsRecordPeriod): Long {
        return Calendar.getInstance().apply {
            timeInMillis = startMillis
            when (period) {
                StepsRecordPeriod.DAY -> add(Calendar.DAY_OF_MONTH, 1)
                StepsRecordPeriod.WEEK -> add(Calendar.DAY_OF_MONTH, DAYS_IN_WEEK)
                StepsRecordPeriod.MONTH -> add(Calendar.MONTH, 1)
                StepsRecordPeriod.YEAR -> add(Calendar.YEAR, 1)
            }
        }.timeInMillis
    }

    private fun Calendar.clearTime() {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }

    private enum class StepsRecordPeriod {
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    private companion object {
        const val DAYS_IN_WEEK = 7
    }
}
