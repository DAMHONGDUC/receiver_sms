package com.receiver.sms.utils.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import com.receiver.sms.domain.use_case.UseCase
import com.receiver.sms.utils.AppConstants

private val LOG_TAG = "SmsReceiverLOG"

class SmsReceiver(private val useCase: UseCase) : BroadcastReceiver() {
    override fun onReceive(
        context: Context?, intent: Intent?
    ) {
        if (context == null || intent == null) {
            return
        }

        if (intent.action.equals(AppConstants.SMS_RECEIVER_INTENT)) {
            val bundle: Bundle? = intent.extras
            if (bundle != null) {
                try {
                    // Retrieve the SMS pdus array using getSerializable
                    val pdus = bundle.getSerializable(AppConstants.SMS_SERIABLE_KEY) as Array<*>

                    for (pdu in pdus) {
                        // Create an SmsMessage from the PDU (Protocol Data Unit)
                        val smsMessage = SmsMessage.createFromPdu(pdu as ByteArray)
                        // Extract details from the SmsMessage
                        val sender = smsMessage.displayOriginatingAddress
                        val messageBody = smsMessage.messageBody
                        // Log the sender and message content (for debugging purposes)
                        Log.d(LOG_TAG, "Sender: $sender")
                        Log.d(LOG_TAG, "Message: $messageBody")
                        // You can also handle the message as needed here
                        // e.g., send to a server, store in a database, etc.
                    }
                } catch (e: Exception) {
                    Log.e(LOG_TAG, "Exception: ${e.message}")
                }
            }
        }
    }
}