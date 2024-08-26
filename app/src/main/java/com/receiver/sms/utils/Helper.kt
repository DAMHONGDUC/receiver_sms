package com.receiver.sms.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.receiver.sms.BuildConfig

class Helper {
    companion object {
        fun openAppSettings(context: Context) {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:" + BuildConfig.APPLICATION_ID)
            context.startActivity(intent)
        }

        fun generateTimeBasedId(): String {
            return System.currentTimeMillis().toString()
        }

    }
}