package com.example.practice.data.steps

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.practice.R
import com.example.practice.data.datastore.StepCounterDataStore
import com.example.practice.domain.models.StepCounterState
import com.example.practice.domain.models.StepsType
import com.example.practice.domain.usecase.StepsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import java.util.Calendar

class StepCounterService : Service(), SensorEventListener, KoinComponent {
    private val stepsUseCase: StepsUseCase by inject()
    private val stepCounterDataStore: StepCounterDataStore by inject()

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var sensorManager: SensorManager? = null

    override fun onCreate() {
        super.onCreate()

        startForeground(
            STEP_NOTIFICATION_ID,
            createStepNotification()
        )

        val manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager = manager
        val stepSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            stopSelf()
            return
        }

        manager.registerListener(
            this,
            stepSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type != Sensor.TYPE_STEP_COUNTER) return

        val totalStepsFromSensor = event.values[0].toInt()

        serviceScope.launch {
            handleStepSensorValue(totalStepsFromSensor)
        }
    }

    private suspend fun handleStepSensorValue(sensorTotalSteps: Int) {
        val todayStartMillis = todayStartMillis()
        var state = stepCounterDataStore.getState()

        if (state.dateStartMillis != todayStartMillis) {
            state = StepCounterState(
                dateStartMillis = todayStartMillis,
                sensorBaseSteps = sensorTotalSteps,
                stepsOffset = 0
            )
        } else if (sensorTotalSteps < state.sensorBaseSteps) {
            val savedTodaySteps = stepsUseCase
                .getStepsSumForAPeriod(
                    fromMillis = todayStartMillis,
                    toMillis = tomorrowStartMillis()
                )
                .first()

            state = StepCounterState(
                dateStartMillis = todayStartMillis,
                sensorBaseSteps = sensorTotalSteps,
                stepsOffset = savedTodaySteps
            )
        }

        val todaySteps = state.stepsOffset + (sensorTotalSteps - state.sensorBaseSteps)

        stepCounterDataStore.saveState(state)

        stepsUseCase.saveAndUpdateSteps(
            StepsType(
                dateStartMillis = todayStartMillis,
                steps = todaySteps,
                updatedAtMillis = System.currentTimeMillis()
            )
        )
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit

    override fun onDestroy() {
        sensorManager?.unregisterListener(this)
        serviceScope.cancel()
        super.onDestroy()
    }

    private fun createStepNotification(): Notification {
        createNotificationChannel()

        return NotificationCompat.Builder(this, STEP_NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_logo)
            .setContentTitle(getString(R.string.step_counter_notification_title))
            .setContentText(getString(R.string.step_counter_notification_text))
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val channel = NotificationChannel(
            STEP_NOTIFICATION_CHANNEL_ID,
            getString(R.string.step_counter_notification_title),
            NotificationManager.IMPORTANCE_LOW
        )

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    private fun todayStartMillis(): Long {
        return Calendar.getInstance().apply {
            clearTime()
        }.timeInMillis
    }

    private fun tomorrowStartMillis(): Long {
        return Calendar.getInstance().apply {
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

    private companion object {
        const val STEP_NOTIFICATION_ID = 1001
        const val STEP_NOTIFICATION_CHANNEL_ID = "step_counter_channel"
    }
}