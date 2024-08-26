package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repository.APIRepository
import com.receiver.sms.domain.model.ReceiverSMSModel

class CallAPIAfterReceiveSMSUseCase(private val apiRepository: APIRepository) {
    suspend operator fun invoke(receiverSMSModel: ReceiverSMSModel) =
        apiRepository.callAPIAfterReceiveSMS(receiverSMSModel)
}