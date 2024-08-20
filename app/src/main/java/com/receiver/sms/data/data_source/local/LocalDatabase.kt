package com.receiver.sms.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.receiver.sms.data.data_source.local.entity.SMSEntity

@Database(
    entities = [SMSEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract val dao: DAO

}