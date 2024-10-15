package com.receiver.sms.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionController {
    companion object {
        fun checkSMSReceiverIsGrant(context: Context): Boolean {
            return ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECEIVE_SMS
            ) == PackageManager.PERMISSION_GRANTED
        }

        fun requestSMSReceiverPermission(context: Context) {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf<String>(
                    Manifest.permission.RECEIVE_SMS
                ),
                1
            )
        }
    }
}