package com.receiver.sms.domain.repositories

import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.domain.model.SMSObserveModel

interface SMSObserveRepository {
    suspend fun getAllSMSObserve(): List<SMSObserveModel>

    suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity): Boolean

    suspend fun getAllSMSObserveBySender(sender: String): List<SMSObserveModel>
}
