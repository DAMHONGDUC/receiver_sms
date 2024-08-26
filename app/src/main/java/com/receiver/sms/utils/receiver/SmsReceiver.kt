package com.receiver.sms.utils.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.use_case.UseCase
import com.receiver.sms.utils.AppConstants
import com.receiver.sms.utils.Helper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                    val pdus = bundle.getSerializable(AppConstants.SMS_SERIABLE_KEY) as Array<*>

                    for (pdu in pdus) {
                        val smsMessage = SmsMessage.createFromPdu(pdu as ByteArray)
                        val sender = smsMessage.displayOriginatingAddress
                        val messageBody = smsMessage.messageBody

                        CoroutineScope(Dispatchers.IO).launch {
                            useCase.callAPIAfterReceiveSMSUseCase(
                                ReceiverSMSModel(
                                    id = Helper.generateTimeBasedId(),
                                    sender = sender,
                                    body = messageBody
                                )
                            )
                        }

                    }
                } catch (e: Exception) {
                    Log.e(LOG_TAG, "Exception: ${e.message}")
                }
            }
        }
    }
}