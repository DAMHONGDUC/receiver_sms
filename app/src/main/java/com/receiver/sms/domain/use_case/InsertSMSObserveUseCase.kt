package com.receiver.sms.domain.use_case

import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.repository.DBSMSRepository

class InsertSMSObserveUseCase(private val dbSMSRepository: DBSMSRepository) {
    suspend operator fun invoke(smsObserveEntity: SMSObserveEntity) =
        dbSMSRepository.insertSMSObserve(smsObserveEntity = smsObserveEntity)
}