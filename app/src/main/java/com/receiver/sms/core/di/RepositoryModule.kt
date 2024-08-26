package com.receiver.sms.core.di

import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.data.repository.DBRepository
import com.receiver.sms.domain.use_case.GetAllSMSObserveUseCase
import com.receiver.sms.domain.use_case.InsertSMSObserveUseCase
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
    fun provideDBSMSRepository(db: LocalDatabase): DBRepository {
        return DBRepository(dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCase(
        dbRepository: DBRepository,
    ): UseCase =
        UseCase(
            getAllSMSObserveUC = GetAllSMSObserveUseCase(dbRepository = dbRepository),
            insertSMSObserveUC = InsertSMSObserveUseCase(dbRepository = dbRepository)
        )
}