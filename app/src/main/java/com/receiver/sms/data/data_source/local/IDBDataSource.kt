package com.receiver.sms.data.data_source.local

import com.receiver.sms.data.data_source.local.entity.ObserveSMSEntity
import com.receiver.sms.domain.model.ObserveSMSModel

interface IDBDataSource {
    suspend fun getAllObserveSMS(): List<ObserveSMSModel>

    suspend fun insertObserveSMS(observeSMSEntity: ObserveSMSEntity): Boolean

}

