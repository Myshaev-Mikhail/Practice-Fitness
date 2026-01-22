package com.example.practice.ui.screens.notificationsetting

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.practice.data.datastore.NotificationSettingsDataStore
import com.example.practice.data.repository.NotificationSettingsRepositoryImpl
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.extensions.notificationSettingsPreferences
import kotlinx.coroutines.flow.first
import java.util.Calendar
import java.util.concurrent.TimeUnit

class NotificationReceiver(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val dataStore = NotificationSettingsDataStore(applicationContext.notificationSettingsPreferences)
        val repository = NotificationSettingsRepositoryImpl(dataStore)
        val useCase = NotificationSettingsUseCase(repository)

        val settings = useCase.observeSettings().first()

        if (!settings.generalEnabled) return Result.success()

        AppNotificationManager().showNotification(
            context = applicationContext,
            soundEnabled = settings.soundEnabled,
            vibrateEnabled = settings.vibrateEnabled
        )

        scheduleNextWorker(
            context = applicationContext,
            hour = settings.hour,
            minute = settings.minute
        )

        return Result.success()
    }

    companion object {
        const val WORK_NAME = "daily_notification"
        const val WORK_TAG = "daily_notification"

        fun scheduleNextWorker(context: Context, hour: Int, minute: Int) {
            val now = Calendar.getInstance()
            val nextRun = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
                if (before(now)) add(Calendar.DATE, 1)
            }

            val delay = nextRun.timeInMillis - now.timeInMillis

            val request = OneTimeWorkRequestBuilder<NotificationReceiver>()
                .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                .addTag(WORK_TAG)
                .build()

            WorkManager.getInstance(context)
                .enqueueUniqueWork(WORK_NAME, ExistingWorkPolicy.REPLACE, request)
        }
    }
}