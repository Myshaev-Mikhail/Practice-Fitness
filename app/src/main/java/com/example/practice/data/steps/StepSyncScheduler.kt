package com.example.practice.data.steps

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object StepSyncScheduler {
    fun start(context: Context) {
        enqueueSync(
            context = context,
            delayMillis = 0L,
            policy = ExistingWorkPolicy.REPLACE
        )
    }

    fun scheduleNext(context: Context) {
        enqueueSync(
            context = context,
            delayMillis = getNextDelayMillis(),
            policy = ExistingWorkPolicy.APPEND_OR_REPLACE
        )
    }

    private fun enqueueSync(
        context: Context,
        delayMillis: Long,
        policy: ExistingWorkPolicy
    ) {
        val request = OneTimeWorkRequestBuilder<StepSyncWorker>()
            .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
            .addTag(WORK_TAG)
            .build()

        WorkManager.getInstance(context.applicationContext)
            .enqueueUniqueWork(WORK_NAME, policy, request)
    }

    private fun getNextDelayMillis(): Long {
        val currentMinutes = java.util.Calendar.getInstance().let { calendar ->
            calendar.get(java.util.Calendar.HOUR_OF_DAY) * MINUTES_IN_HOUR +
                    calendar.get(java.util.Calendar.MINUTE)
        }

        val delayMinutes = when {
            currentMinutes in EVENING_START_MINUTES until NIGHT_START_MINUTES -> {
                minOf(EVENING_SYNC_INTERVAL_MINUTES, NIGHT_START_MINUTES - currentMinutes)
            }

            currentMinutes >= NIGHT_START_MINUTES ||
                    currentMinutes < AFTER_MIDNIGHT_END_MINUTES -> {
                val minutesUntilNightEnd = if (currentMinutes >= NIGHT_START_MINUTES) {
                    MINUTES_IN_DAY - currentMinutes + AFTER_MIDNIGHT_END_MINUTES
                } else {
                    AFTER_MIDNIGHT_END_MINUTES - currentMinutes
                }

                minOf(NIGHT_SYNC_INTERVAL_MINUTES, minutesUntilNightEnd)
            }

            currentMinutes in AFTER_MIDNIGHT_END_MINUTES until EARLY_MORNING_END_MINUTES -> {
                minOf(EVENING_SYNC_INTERVAL_MINUTES, EARLY_MORNING_END_MINUTES - currentMinutes)
            }

            else -> {
                val minutesUntilEvening = if (currentMinutes < EVENING_START_MINUTES) {
                    EVENING_START_MINUTES - currentMinutes
                } else {
                    MINUTES_IN_DAY - currentMinutes + EVENING_START_MINUTES
                }

                minOf(DAY_SYNC_INTERVAL_MINUTES, minutesUntilEvening)
            }
        }.coerceAtLeast(1)

        return TimeUnit.MINUTES.toMillis(delayMinutes.toLong())
    }

    private const val WORK_NAME = "step_sync"
    private const val WORK_TAG = "step_sync"

    private const val MINUTES_IN_HOUR = 60
    private const val MINUTES_IN_DAY = 24 * MINUTES_IN_HOUR

    private const val AFTER_MIDNIGHT_END_MINUTES = 1 * MINUTES_IN_HOUR
    private const val EARLY_MORNING_END_MINUTES = 2 * MINUTES_IN_HOUR
    private const val EVENING_START_MINUTES = 21 * MINUTES_IN_HOUR
    private const val NIGHT_START_MINUTES = 23 * MINUTES_IN_HOUR

    private const val DAY_SYNC_INTERVAL_MINUTES = 120
    private const val EVENING_SYNC_INTERVAL_MINUTES = 30
    private const val NIGHT_SYNC_INTERVAL_MINUTES = 10
}
