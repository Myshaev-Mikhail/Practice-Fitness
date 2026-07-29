package com.example.practice.ui.screens.notificationsetting

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.AudioAttributes
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.practice.MainActivity
import com.example.practice.R
import java.util.Locale

class AppNotificationManager {
    fun showNotification(
        context: Context,
        soundEnabled: Boolean,
        vibrateEnabled: Boolean,
        language: String = "en"
    ) {
        val localizedContext = context.withAppLocale(language)

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
            val channel = NotificationChannel(
                channelId,
                localizedContext.getString(R.string.reminder_notifications),
                importance
            )

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

        val titles = localizedContext.resources.getStringArray(R.array.motivation_titles)
        val texts = localizedContext.resources.getStringArray(R.array.motivation_texts)
        val messageIndex = titles.indices.random()
        val title = titles[messageIndex]
        val text = texts.getOrElse(messageIndex) { title }

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
    }
}

private fun Context.withAppLocale(language: String): Context {
    val locale = when (language) {
        "ru" -> Locale.Builder()
            .setLanguage("ru")
            .setRegion("RU")
            .build()
        else -> Locale.Builder()
            .setLanguage("en")
            .build()
    }
    val configuration = Configuration(resources.configuration).apply {
        setLocale(locale)
    }
    return createConfigurationContext(configuration)
}
