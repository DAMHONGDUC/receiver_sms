package com.receiver.sms.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.utils.SMSDatabaseConstants

@Dao
interface DAO {
    @Query("SELECT * FROM ${SMSDatabaseConstants.SMS_OBSERVE_TABLE}")
    fun getAllSMSObserve(): List<SMSObserveEntity>

    @Insert(entity = SMSObserveEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSMSObserve(smsObserveEntity: SMSObserveEntity)

}