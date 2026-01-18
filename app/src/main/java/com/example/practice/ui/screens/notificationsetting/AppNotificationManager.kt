package com.example.practice.ui.screens.notificationsetting

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.practice.MainActivity
import com.example.practice.R

class AppNotificationManager {
    fun showNotification(
        context: Context,
        soundEnabled: Boolean,
        vibrateEnabled: Boolean
    ) {
        val channelId = if (soundEnabled && vibrateEnabled) {
            "REMINDER_CHANNEL_SOUND_VIBRATE"
        } else if (soundEnabled) {
            "REMINDER_CHANNEL_SOUND"
        } else if (vibrateEnabled) {
            "REMINDER_CHANNEL_VIBRATE"
        } else {
            "REMINDER_CHANNEL_NONE"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.deleteNotificationChannel(channelId)

            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, "Reminder Notifications", importance)

            if (soundEnabled) {
                val soundUri = Settings.System.DEFAULT_NOTIFICATION_URI
                channel.setSound(
                    soundUri,
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build()
                )
            } else {
                channel.setSound(null, null)
            }

            channel.enableVibration(vibrateEnabled)
            channel.vibrationPattern = if (vibrateEnabled) longArrayOf(0, 100, 50, 100) else null

            manager.createNotificationChannel(channel)
        }

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val (title, text) = motivationMessages.random()

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_logo)
            .setContentTitle(title)
            .setContentText(text)
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
    }

    companion object {
        private const val NOTIFICATION_ID = 1001

        val motivationMessages = listOf(
            "Вперёд!" to "Начни тренироваться прямо сейчас",
            "Держись!" to "Каждое движение приближает к цели",
            "Сила!" to "Ты сильнее, чем думаешь",
            "Время!" to "Не откладывай тренировку на завтра",
            "Результат!" to "Маленькая тренировка — большой прогресс",
            "Фокус!" to "Сосредоточься и двигайся к цели",
            "Энергия!" to "Активность делает тебя сильнее",
            "Прогресс!" to "Сегодня лучше, чем вчера",
            "Действуй!" to "Не сдавайся, шаг за шагом",
            "Мотивация!" to "Каждое усилие приносит результат",
            "Смелость!" to "Попробуй и достигни цели",
            "Сила воли!" to "Не останавливайся на полпути",
            "Движение!" to "Каждое действие делает тебя лучше",
            "Вдохновение!" to "Начни день с активности",
            "Цель!" to "Каждый шаг приближает к успеху",
            "Успех!" to "Продолжай идти, результат близко",
            "Старт!" to "Немного усилий сегодня — прогресс завтра",
            "Победа!" to "Твое тело скажет спасибо",
            "Активность!" to "Делай хотя бы маленький шаг",
            "Сила духа!" to "Тренируйся и становись сильнее"
        )
    }
}