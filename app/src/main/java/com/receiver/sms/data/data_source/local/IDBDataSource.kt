package com.receiver.sms.data.data_source.local

import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.domain.model.SMSObserveModel

interface IDBDataSource {
    suspend fun getAllSMSObserve(): List<SMSObserveModel>

    suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity): Boolean

    suspend fun getAllSMSObserveBySender(sender: String): List<SMSObserveModel>
}

