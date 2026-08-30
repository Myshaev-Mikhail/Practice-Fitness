package com.example.practice.data.steps

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.os.HandlerThread
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.resume

class StepSensorReader(private val context: Context) {
    suspend fun readTotalSteps(): Int? {
        return withTimeoutOrNull(SENSOR_READ_TIMEOUT_MILLIS) {
            suspendCancellableCoroutine { continuation ->
                val sensorManager =
                    context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
                val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

                if (stepSensor == null) {
                    continuation.resume(null)
                    return@suspendCancellableCoroutine
                }

                val handlerThread = HandlerThread(STEP_READER_THREAD_NAME).apply {
                    start()
                }

                lateinit var listener: SensorEventListener
                listener = object : SensorEventListener {
                    override fun onSensorChanged(event: SensorEvent) {
                        if (event.sensor.type != Sensor.TYPE_STEP_COUNTER) return

                        sensorManager.unregisterListener(listener)
                        handlerThread.quitSafely()

                        if (continuation.isActive) {
                            continuation.resume(event.values[0].toInt())
                        }
                    }

                    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
                }

                continuation.invokeOnCancellation {
                    sensorManager.unregisterListener(listener)
                    handlerThread.quitSafely()
                }

                val isRegistered = sensorManager.registerListener(
                    listener,
                    stepSensor,
                    SensorManager.SENSOR_DELAY_NORMAL,
                    Handler(handlerThread.looper)
                )

                if (!isRegistered) {
                    sensorManager.unregisterListener(listener)
                    handlerThread.quitSafely()

                    if (continuation.isActive) {
                        continuation.resume(null)
                    }
                }
            }
        }
    }

    private companion object {
        const val SENSOR_READ_TIMEOUT_MILLIS = 10_000L
        const val STEP_READER_THREAD_NAME = "StepSensorReader"
    }
}
