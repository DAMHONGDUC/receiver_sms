package com.receiver.sms.data.repositories_impl

import com.receiver.sms.data.data_source.local.DAO
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.data.data_source.local.entity.toDomain
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.domain.repositories.SMSObserveRepository
import javax.inject.Inject

private const val LOG_TAG = "DBRepositoryLOG"

class SMSObserveRepositoryImpl @Inject constructor(
    private val dao: DAO,
) : SMSObserveRepository {
    override suspend fun getAllSMSObserve(): List<SMSObserveModel> {
        val listSMSObserveEntity: List<SMSObserveEntity> = dao.getAllSMSObserve()

        return listSMSObserveEntity.map { it.toDomain() }
    }

    override suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity): Boolean {
        dao.insertSMSObserve(smsObserveEntity = smsObserveEntity)

        return true
    }

    override suspend fun getAllSMSObserveBySender(sender: String): List<SMSObserveModel> {
        val listSMSObserveEntity: List<SMSObserveEntity> = dao.getAllSMSObserveBySender(sender)

        return listSMSObserveEntity.map { it.toDomain() }
    }
}