package com.receiver.sms.domain.use_case

import com.receiver.sms.data.data_source.local.entity.ObserveSMSEntity
import com.receiver.sms.data.repository.DBSMSRepository

class InsertObserveSMSUseCase(private val dbSMSRepository: DBSMSRepository) {
    suspend operator fun invoke(observeSMSEntity: ObserveSMSEntity) =
        dbSMSRepository.insertObserveSMS(observeSMSEntity = observeSMSEntity)
}