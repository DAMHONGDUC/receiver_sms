package com.receiver.sms.data.repository

import com.receiver.sms.data.data_source.local.DAO
import com.receiver.sms.data.data_source.local.IDBDataSource
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.data_source.local.entity.toDomain
import com.receiver.sms.domain.model.SMSObserveModel
import javax.inject.Inject

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
}