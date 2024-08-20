package com.receiver.sms.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.receiver.sms.data.data_source.local.entity.SMSEntity
import com.receiver.sms.utils.SMSDatabaseConstants

@Dao
interface DAO {
    @Query("SELECT * FROM ${SMSDatabaseConstants.SMS_TABLE}")
    fun getAllSMS(): List<SMSEntity>

    @Insert(entity = SMSEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSMS(smsEntity: SMSEntity)
}