package com.mohaberabi.androidnotifications.notifications

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showMediaNotification() {


    val style =
        androidx.media.app.NotificationCompat.MediaStyle().setShowActionsInCompactView(0, 1, 2)
    val next = MediaNotificationReceiverNext.pendingIntent(this)
    val prev = MediaNotificationReceiverPrevious.pendingIntent(this)
    val play = MediaNotificationReceiverPlay.pendingIntent(this)
    val playPause = MediaNotificationReceiverPlayPause.pendingIntent(this)

    val icon = BitmapFactory.decodeResource(resources, R.drawable.big_pic)
    val noti = notificationBuilder()
        .setContentTitle("You are playing")
        .setContentText("some dummy song")
        .addAction(R.drawable.ic_play, "play", next)
        .addAction(R.drawable.ic_prev, "prev", prev)
        .addAction(R.drawable.ic_pause, "pause", playPause)
        .addAction(R.drawable.ic_play, "playPause", playPause)
        .setLargeIcon(icon)
        .setStyle(style)
        .build()

    notificationManager.notify(15, noti)

}


class MediaNotificationReceiverNext : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE = 1
        fun pendingIntent(ctx: Context): PendingIntent {
            val intent = Intent(ctx, MediaNotificationReceiverNext::class.java)
            return PendingIntent.getBroadcast(ctx, REQUEST_CODE, intent, PendingIntent.FLAG_MUTABLE)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {


    }
}

class MediaNotificationReceiverPrevious : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE = 2
        fun pendingIntent(ctx: Context): PendingIntent {
            val intent = Intent(ctx, MediaNotificationReceiverPrevious::class.java)
            return PendingIntent.getBroadcast(ctx, REQUEST_CODE, intent, PendingIntent.FLAG_MUTABLE)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {


    }
}

class MediaNotificationReceiverPlay : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE = 3
        fun pendingIntent(ctx: Context): PendingIntent {
            val intent = Intent(ctx, MediaNotificationReceiverPlay::class.java)
            return PendingIntent.getBroadcast(ctx, REQUEST_CODE, intent, PendingIntent.FLAG_MUTABLE)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {


    }
}

class MediaNotificationReceiverPlayPause : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE = 3
        fun pendingIntent(ctx: Context): PendingIntent {
            val intent = Intent(ctx, MediaNotificationReceiverPlayPause::class.java)
            return PendingIntent.getBroadcast(ctx, REQUEST_CODE, intent, PendingIntent.FLAG_MUTABLE)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {


    }
}