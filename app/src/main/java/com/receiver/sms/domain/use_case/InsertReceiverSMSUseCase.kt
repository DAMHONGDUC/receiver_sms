package com.receiver.sms.domain.use_case

import com.receiver.sms.data.data_source.local.entity.ReceiverSMSEntity
import com.receiver.sms.data.repository.DBRepository

class InsertReceiverSMSUseCase(private val dbRepository: DBRepository) {
    suspend operator fun invoke(receiverSMSEntity: ReceiverSMSEntity) =
        dbRepository.insertReceiverSMS(receiverSMSEntity)
}