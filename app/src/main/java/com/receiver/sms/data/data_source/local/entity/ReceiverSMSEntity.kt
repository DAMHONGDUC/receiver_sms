package com.receiver.sms.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.utils.SMSDatabaseConstants

@Entity(tableName = SMSDatabaseConstants.RECEIVER_SMS_TABLE)
data class ReceiverSMSEntity(
    @PrimaryKey
    val id: Int = 1, // Always 1 since there's only one row
    val sender: String,
    val body: String,
    val timestamp: String
)

fun ReceiverSMSEntity.toDomain(): ReceiverSMSModel {
    return ReceiverSMSModel(
        sender = sender,
        body = body,
        timestamp = timestamp
    )
}
