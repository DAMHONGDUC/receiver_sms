package com.receiver.sms.domain.use_case

import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.repositories_impl.SMSObserveRepositoryImpl

class InsertSMSObserveUC(private val repository: SMSObserveRepositoryImpl) {
    suspend operator fun invoke(smsObserveEntity: SMSObserveEntity) =
        repository.insertSMSObserve(smsObserveEntity)
}