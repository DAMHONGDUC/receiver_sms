package com.receiver.sms.core.resources

object AppConstants {
    const val SMS_RECEIVER_INTENT = "android.provider.Telephony.SMS_RECEIVED"
    const val SMS_SERIABLE_KEY = "pdus"
    const val SMS_INTENT = "SmsMessage.intent.MAIN"
}

object SMSDatabaseConstants {
    const val DB_NAME = "DB_SMS_Database"
    const val SMS_OBSERVE_TABLE = "SMS_OBSERVE_TABLE"
    const val RECEIVER_SMS_TABLE = "RECEIVER_SMS_TABLE"
}