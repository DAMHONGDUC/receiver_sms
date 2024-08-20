package com.receiver.sms.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.receiver.sms.data.data_source.local.entity.ObserveSMSEntity
import com.receiver.sms.utils.SMSDatabaseConstants

@Dao
interface DAO {
    @Query("SELECT * FROM ${SMSDatabaseConstants.OBSERVE_SMS_TABLE}")
    fun getAllObserveSMS(): List<ObserveSMSEntity>

    @Insert(entity = ObserveSMSEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObserveSMS(observeSMSEntity: ObserveSMSEntity)
}