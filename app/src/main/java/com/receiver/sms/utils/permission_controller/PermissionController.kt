package com.receiver.sms.utils.permission_controller

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionController {
    companion object {
        fun checkSMSReceiverPermission(context: Context): Boolean {
            return ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECEIVE_SMS
            ) == PackageManager.PERMISSION_GRANTED
        }

        fun requestSMSReceiverPermission(context: Context) {
            
        }
    }
}