package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repositories_impl.SMSObserveRepositoryImpl

class GetAllSMSObserveUC(private val repository: SMSObserveRepositoryImpl) {
    suspend operator fun invoke() = repository.getAllSMSObserve()
}