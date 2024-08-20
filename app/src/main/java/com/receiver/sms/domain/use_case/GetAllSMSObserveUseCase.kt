package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repository.DBSMSRepository

class GetAllSMSObserveUseCase(private val dbSMSRepository: DBSMSRepository) {
    suspend operator fun invoke() = dbSMSRepository.getAllSMSObserve()
}