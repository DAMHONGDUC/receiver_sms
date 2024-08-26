package com.receiver.sms.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.utils.SMSDatabaseConstants

@Entity(tableName = SMSDatabaseConstants.SMS_OBSERVE_TABLE)
data class SMSObserveEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sender: String,
    val message: String,
    val body: String,
    val header: String,
)

fun SMSObserveEntity.toDomain(): SMSObserveModel {
    return SMSObserveModel(
        id = this.id,
        sender = this.sender,
        message = this.message,
        body = this.body,
        header = this.header,
    )
}

