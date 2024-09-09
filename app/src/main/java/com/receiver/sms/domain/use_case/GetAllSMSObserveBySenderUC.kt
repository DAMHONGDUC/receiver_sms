package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repository.DBRepository

class GetAllSMSObserveBySenderUC(private val dbRepository: DBRepository) {
    suspend operator fun invoke(sender: String) =
        dbRepository.getAllSMSObserveBySender(sender)
}