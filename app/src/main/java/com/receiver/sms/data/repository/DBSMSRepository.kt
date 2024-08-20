package com.receiver.sms.data.repository

import com.receiver.sms.data.data_source.local.DAO
import com.receiver.sms.data.data_source.local.IDBDataSource
import com.receiver.sms.data.data_source.local.entity.ObserveSMSEntity
import com.receiver.sms.data.data_source.local.entity.toDomain
import com.receiver.sms.domain.model.ObserveSMSModel
import javax.inject.Inject

class DBSMSRepository @Inject constructor(
    private val dao: DAO,
) : IDBDataSource {
    override suspend fun getAllObserveSMS(): List<ObserveSMSModel> {
        val listObserveSMSEntity: List<ObserveSMSEntity> = dao.getAllObserveSMS()

        return listObserveSMSEntity.map { it.toDomain() }
    }

    override suspend fun insertObserveSMS(observeSMSEntity: ObserveSMSEntity): Boolean {
        dao.insertObserveSMS(observeSMSEntity = observeSMSEntity)

        return true
    }
}