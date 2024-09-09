package com.receiver.sms.domain.use_case

import android.util.Log
import com.receiver.sms.data.repository.APIRepository
import com.receiver.sms.data.repository.DBRepository
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.model.SMSObserveModel

private val LOG_TAG = "CallAPIAfterReceiveSMSUCLOG"

class CallAPIAfterReceiveSMSUC(
    private val apiRepository: APIRepository,
    private val dbRepository: DBRepository
) {
    suspend operator fun invoke(receiverSMSModel: ReceiverSMSModel): Result<Unit> {
        try {
            val listSMSObserveBySender: List<SMSObserveModel> =
                dbRepository.getAllSMSObserveBySender(receiverSMSModel.sender)

            Log.d(LOG_TAG, listSMSObserveBySender.toString())

            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }

}