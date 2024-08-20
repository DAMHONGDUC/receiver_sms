package com.receiver.sms.data.data_source.local

import androidx.lifecycle.LiveData
import com.receiver.sms.data.data_source.local.entity.SMSEntity
import com.receiver.sms.domain.model.SMSModel

interface IDBDataSource {
    suspend fun getAllSMS(): LiveData<SMSModel?>

    suspend fun insertSMS(smsEntity: SMSEntity): Boolean

}

