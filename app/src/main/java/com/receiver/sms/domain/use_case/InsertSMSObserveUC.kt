package com.receiver.sms.domain.use_case

import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.repository.DBRepository

class InsertSMSObserveUC(private val dbRepository: DBRepository) {
    suspend operator fun invoke(smsObserveEntity: SMSObserveEntity) =
        dbRepository.insertSMSObserve(smsObserveEntity)
}