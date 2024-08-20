package com.receiver.sms.utils

object AppConstants {
    const val SMS_RECEIVER_INTENT = "android.provider.Telephony.SMS_RECEIVED"
    const val SMS_SERIABLE_KEY = "pdus"
}

object SMSDatabaseConstants {
    const val DB_NAME = "DB_SMS_Database"
    const val SMS_TABLE = "SMS_TABLE"
    const val LIVE_SMS_TABLE = "LIVE_SMS_TABLE"
}