package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repository.DBRepository

class GetAllSMSObserveUseCase(private val dbRepository: DBRepository) {
    suspend operator fun invoke() = dbRepository.getAllSMSObserve()
}