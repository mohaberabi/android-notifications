package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import com.mohaberabi.androidnotifications.notifications.base.AppNotificationsGroups
import com.mohaberabi.androidnotifications.utils.notificationManager
import kotlin.random.Random


fun Context.showGroupedNotification() {


    val builder = notificationBuilder().setGroup(AppNotificationsGroups.CHAT)

    val notifications = buildList {
        repeat(10) {
            val newBuilder = builder.setContentText("notification grouped body $it  ")
                .setContentTitle("notification grouped title $it")
            if (it == 9) {
                newBuilder.setGroupSummary(true)
            }
            add(newBuilder.build())
        }

    }
    notifications.forEachIndexed { index, noti ->
        notificationManager.notify(index + 10, noti)
    }

}