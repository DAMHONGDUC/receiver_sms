package com.receiver.sms.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.receiver.sms.App
import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.utils.SMSDatabaseConstants
import com.receiver.sms.utils.view_model.ResultHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): App {
        return app as App
    }

    @Provides
    @Singleton
    fun provideLocalDB(app: Application): LocalDatabase {
        return Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            SMSDatabaseConstants.DB_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideResultHandler(): ResultHandler {
        return ResultHandler()
    }
}