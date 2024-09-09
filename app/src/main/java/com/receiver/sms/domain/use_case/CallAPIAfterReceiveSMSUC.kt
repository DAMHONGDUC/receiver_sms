package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repository.APIRepository
import com.receiver.sms.data.repository.DBRepository
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.model.SMSObserveModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

private val LOG_TAG = "CallAPIAfterReceiveSMSUCLOG"

class CallAPIAfterReceiveSMSUC(
    private val apiRepository: APIRepository,
    private val dbRepository: DBRepository
) {
    suspend operator fun invoke(receiverSMSModel: ReceiverSMSModel): Result<Unit> {
        return try {
            val listSMSObserveBySender: List<SMSObserveModel> =
                dbRepository.getAllSMSObserveBySender(receiverSMSModel.sender)
            
            coroutineScope {
                listSMSObserveBySender.map { smsObserveModel ->
                    async {
                        apiRepository.callAPIAfterReceiveSMS(smsObserveModel)
                        // write log to db here if needed
                    }
                }.awaitAll()
            }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}