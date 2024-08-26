package com.receiver.sms.utils.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import com.receiver.sms.utils.AppConstants

private const val LOG_TAG = "SmsReceiverLOG"

class SmsReceiver :
    BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) {
            return
        }

        if (intent.action.equals(AppConstants.SMS_RECEIVER_INTENT)) {
            val bundle: Bundle? = intent.extras
            if (bundle != null) {
                try {
//                    CoroutineScope(Dispatchers.IO).launch {
//                        useCase.insertReceiverSMSUC(
//                            ReceiverSMSEntity(
//                                sender = "sender",
//                                body = "messageBody",
//                                timestamp = Helper.getFormattedTimeStamp()
//                            )
//                        )
//                    }
                    val pdus = bundle.getSerializable(AppConstants.SMS_SERIABLE_KEY) as Array<*>

                    for (pdu in pdus) {
                        val smsMessage = SmsMessage.createFromPdu(pdu as ByteArray)
                        val sender = smsMessage.displayOriginatingAddress
                        val messageBody = smsMessage.messageBody

                    }
                } catch (e: Exception) {
                    Log.e(LOG_TAG, "Exception: ${e.message}")
                }
            }
        }
    }
}