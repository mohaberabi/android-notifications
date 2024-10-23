package com.mohaberabi.androidnotifications.utils

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService


val Context.notificationManager get() = getSystemService<NotificationManager>()!!
fun Context.grantedNotificationPermission(
): Boolean = if (requiresNotificationsChannel()) {
    grantedPermission(Manifest.permission.POST_NOTIFICATIONS)
} else true

fun Context.grantedPermission(
    permission: String,
): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) ==
            PackageManager.PERMISSION_GRANTED
}

fun requiresNotificationsChannel(): Boolean {
    return Build.VERSION.SDK_INT >= 33
}