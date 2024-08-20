package com.receiver.sms.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.receiver.sms.domain.model.ObserveSMSModel
import com.receiver.sms.utils.SMSDatabaseConstants

@Entity(tableName = SMSDatabaseConstants.OBSERVE_SMS_TABLE)
data class ObserveSMSEntity(
    @PrimaryKey
    val id: Int,
    val sender: String,
    val message: String,
    val body: String,
    val header: String,
)

fun ObserveSMSEntity.toDomain(): ObserveSMSModel {
    return ObserveSMSModel(
        id = this.id,
        sender = this.sender,
        message = this.message,
        body = this.body,
        header = this.header,
        )
}

