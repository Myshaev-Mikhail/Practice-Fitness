package com.example.practice.data.steps

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.practice.data.datastore.StepCounterDataStore
import com.example.practice.domain.models.StepCounterState
import com.example.practice.domain.models.StepsType
import com.example.practice.domain.usecase.StepsUseCase
import com.example.practice.extensions.hasStepsPermission
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.Calendar
import kotlin.math.roundToInt

class StepSyncWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams), KoinComponent {
    private val stepsUseCase: StepsUseCase by inject()
    private val stepCounterDataStore: StepCounterDataStore by inject()

    override suspend fun doWork(): Result {
        if (!applicationContext.hasStepsPermission()) return Result.success()

        return runCatching {
            val sensorTotalSteps = StepSensorReader(applicationContext).readTotalSteps()

            if (sensorTotalSteps != null) {
                syncSteps(sensorTotalSteps)
            }
            StepSyncScheduler.scheduleNext(applicationContext)

            Result.success()
        }.getOrElse {
            Result.retry()
        }
    }

    private suspend fun syncSteps(sensorTotalSteps: Int) {
        val nowMillis = System.currentTimeMillis()
        val todayStartMillis = getDayStartMillis(nowMillis)
        val state = stepCounterDataStore.getState()

        if (state.lastSyncMillis == 0L || state.dateStartMillis == 0L) {
            saveCurrentState(
                dateStartMillis = todayStartMillis,
                sensorTotalSteps = sensorTotalSteps,
                nowMillis = nowMillis
            )
            return
        }

        if (sensorTotalSteps < state.sensorBaseSteps || state.lastSyncMillis >= nowMillis) {
            saveCurrentState(
                dateStartMillis = todayStartMillis,
                sensorTotalSteps = sensorTotalSteps,
                nowMillis = nowMillis
            )
            return
        }

        val delta = sensorTotalSteps - state.sensorBaseSteps
        if (delta > 0) {
            splitDeltaByDays(
                delta = delta,
                fromMillis = state.lastSyncMillis,
                toMillis = nowMillis
            ).forEach { dayDelta ->
                saveAdditionalStepsForDay(
                    dateStartMillis = dayDelta.dateStartMillis,
                    additionalSteps = dayDelta.steps,
                    nowMillis = nowMillis
                )
            }
        }

        saveCurrentState(
            dateStartMillis = todayStartMillis,
            sensorTotalSteps = sensorTotalSteps,
            nowMillis = nowMillis
        )
    }

    private suspend fun saveCurrentState(
        dateStartMillis: Long,
        sensorTotalSteps: Int,
        nowMillis: Long
    ) {
        stepCounterDataStore.saveState(
            StepCounterState(
                dateStartMillis = dateStartMillis,
                sensorBaseSteps = sensorTotalSteps,
                stepsOffset = getStepsForDay(dateStartMillis),
                lastSyncMillis = nowMillis
            )
        )
    }

    private suspend fun saveAdditionalStepsForDay(
        dateStartMillis: Long,
        additionalSteps: Int,
        nowMillis: Long
    ) {
        if (additionalSteps <= 0) return

        val oldSteps = getStepsForDay(dateStartMillis)
        stepsUseCase.saveAndUpdateSteps(
            StepsType(
                dateStartMillis = dateStartMillis,
                steps = oldSteps + additionalSteps,
                updatedAtMillis = nowMillis
            )
        )
    }

    private suspend fun getStepsForDay(dateStartMillis: Long): Int {
        return stepsUseCase
            .getStepsSumForAPeriod(
                fromMillis = dateStartMillis,
                toMillis = getNextDayStartMillis(dateStartMillis)
            )
            .first()
    }

    private fun splitDeltaByDays(
        delta: Int,
        fromMillis: Long,
        toMillis: Long
    ): List<DayStepsDelta> {
        val totalDuration = toMillis - fromMillis
        if (delta <= 0 || totalDuration <= 0L) return emptyList()

        val result = mutableListOf<DayStepsDelta>()
        var cursorMillis = fromMillis
        var remainingSteps = delta

        while (cursorMillis < toMillis && remainingSteps > 0) {
            val dateStartMillis = getDayStartMillis(cursorMillis)
            val segmentEndMillis = minOf(getNextDayStartMillis(dateStartMillis), toMillis)
            val isLastSegment = segmentEndMillis >= toMillis
            val segmentDuration = segmentEndMillis - cursorMillis
            val stepsForSegment = if (isLastSegment) {
                remainingSteps
            } else {
                ((delta * segmentDuration.toFloat()) / totalDuration)
                    .roundToInt()
                    .coerceIn(0, remainingSteps)
            }

            if (stepsForSegment > 0) {
                result += DayStepsDelta(
                    dateStartMillis = dateStartMillis,
                    steps = stepsForSegment
                )
                remainingSteps -= stepsForSegment
            }

            cursorMillis = segmentEndMillis
        }

        return result
    }

    private fun getDayStartMillis(millis: Long): Long {
        return Calendar.getInstance().apply {
            timeInMillis = millis
            clearTime()
        }.timeInMillis
    }

    private fun getNextDayStartMillis(dateStartMillis: Long): Long {
        return Calendar.getInstance().apply {
            timeInMillis = dateStartMillis
            clearTime()
            add(Calendar.DAY_OF_MONTH, 1)
        }.timeInMillis
    }

    private fun Calendar.clearTime() {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }

    private data class DayStepsDelta(
        val dateStartMillis: Long,
        val steps: Int
    )
}
