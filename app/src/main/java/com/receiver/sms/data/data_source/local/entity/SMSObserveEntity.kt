package com.receiver.sms.data.data_source.local.entity

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.receiver.sms.core.resources.SMSDatabaseConstants
import com.receiver.sms.domain.model.SMSObserveModel
import java.time.ZonedDateTime

@Entity(tableName = SMSDatabaseConstants.SMS_OBSERVE_TABLE)
data class SMSObserveEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sender: String,
    val endpoint: String,
    val body: String,
    val header: String,
    val createdAt: String,
    val updatedAt: String,
)

@RequiresApi(Build.VERSION_CODES.O)
fun SMSObserveEntity.toDomain(): SMSObserveModel {
    return SMSObserveModel(
        id = this.id,
        sender = this.sender,
        endpoint = this.endpoint,
        body = this.body,
        header = this.header,
        createdAt = ZonedDateTime.parse(this.createdAt),
        updatedAt = ZonedDateTime.parse(this.updatedAt)
    )
}

