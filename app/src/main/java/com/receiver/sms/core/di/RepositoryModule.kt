package com.receiver.sms.core.di

import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.data.repository.DBSMSRepository
import com.receiver.sms.domain.use_case.GetAllObserveSMSUseCase
import com.receiver.sms.domain.use_case.InsertObserveSMSUseCase
import com.receiver.sms.domain.use_case.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideDBSMSRepository(db: LocalDatabase): DBSMSRepository {
        return DBSMSRepository(dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCase(
        dbSMSRepository: DBSMSRepository,
    ): UseCase =
        UseCase(
            getAllObserveSMS = GetAllObserveSMSUseCase(dbSMSRepository = dbSMSRepository),
            insertObserveSMS = InsertObserveSMSUseCase(dbSMSRepository = dbSMSRepository)
        )
}