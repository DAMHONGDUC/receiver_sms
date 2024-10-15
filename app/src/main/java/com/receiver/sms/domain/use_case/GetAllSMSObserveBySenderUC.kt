package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repositories_impl.SMSObserveRepositoryImpl

class GetAllSMSObserveBySenderUC(private val repository: SMSObserveRepositoryImpl) {
    suspend operator fun invoke(sender: String) =
        repository.getAllSMSObserveBySender(sender)
}