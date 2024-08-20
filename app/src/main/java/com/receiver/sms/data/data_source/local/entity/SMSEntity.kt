package com.receiver.sms.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.receiver.sms.utils.SMSDatabaseConstants

@Entity(tableName = SMSDatabaseConstants.SMS_TABLE)
data class SMSEntity(
    @PrimaryKey
    val id: Int,
    val sender: String,
    val message: String,
    val timestamp: String,
)


