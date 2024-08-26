package com.receiver.sms.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.receiver.sms.data.data_source.local.DAO
import com.receiver.sms.data.data_source.local.IDBDataSource
import com.receiver.sms.data.data_source.local.entity.ReceiverSMSEntity
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.data_source.local.entity.toDomain
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.model.SMSObserveModel
import javax.inject.Inject

private const val LOG_TAG = "DBRepositoryLOG"

class DBRepository @Inject constructor(
    private val dao: DAO,
) : IDBDataSource {
    override suspend fun getAllSMSObserve(): List<SMSObserveModel> {
        val listSMSObserveEntity: List<SMSObserveEntity> = dao.getAllSMSObserve()

        return listSMSObserveEntity.map { it.toDomain() }
    }

    override suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity): Boolean {
        dao.insertSMSObserve(smsObserveEntity = smsObserveEntity)

        return true
    }

    override suspend fun getReceiverSMS(): LiveData<ReceiverSMSModel?> {
        val result = MediatorLiveData<ReceiverSMSModel>()
        val entityLiveData = dao.getReceiverSMS()

        result.addSource(entityLiveData) { entity ->
            result.value = entity?.toDomain()
        }

        return result
    }

    override suspend fun insertReceiverSMS(receiverSMSEntity: ReceiverSMSEntity): Boolean {
        Log.d(LOG_TAG, receiverSMSEntity.toString())
        dao.insertReceiverSMS(receiverSMSEntity)
        
        return true
    }
}