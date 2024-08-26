package com.receiver.sms.data.data_source.local

import androidx.lifecycle.LiveData
import com.receiver.sms.data.data_source.local.entity.ReceiverSMSEntity
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.model.SMSObserveModel

interface IDBDataSource {
    suspend fun getAllSMSObserve(): List<SMSObserveModel>

    suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity): Boolean

    suspend fun getReceiverSMS(): LiveData<ReceiverSMSModel?>

    suspend fun insertReceiverSMS(receiverSMSEntity: ReceiverSMSEntity): Boolean
}

