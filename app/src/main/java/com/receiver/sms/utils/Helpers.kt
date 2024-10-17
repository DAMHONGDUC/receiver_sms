package com.receiver.sms.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.receiver.sms.BuildConfig
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class Helpers {
    companion object {
        fun openAppSettings(context: Context) {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:" + BuildConfig.APPLICATION_ID)
            context.startActivity(intent)
        }

        fun generateTimeBasedId(): String {
            return System.currentTimeMillis().toString()
        }

        fun getFormattedTimeStamp(): String {
            val timeStamp = System.currentTimeMillis()
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = Date(timeStamp)
            return sdf.format(date)
        }

    }
}

class DateFormatHelpers {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun formatDateStr(dateSt: String): String {
            val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val formattedDate = LocalDateTime.parse(dateSt, dateFormatter)
            
            return DateTimeFormatter.ofPattern("MMMM dd, yyyy | hh:mma")
                .format(formattedDate)
        }

    }
}