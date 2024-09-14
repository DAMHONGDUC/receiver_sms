package com.receiver.sms.core.di

import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.data.repository.APIRepository
import com.receiver.sms.data.repository.DBRepository
import com.receiver.sms.domain.use_case.CallAPIAfterReceiveSMSUC
import com.receiver.sms.domain.use_case.GetAllSMSObserveBySenderUC
import com.receiver.sms.domain.use_case.GetAllSMSObserveUC
import com.receiver.sms.domain.use_case.InsertSMSObserveUC
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
    fun provideDBRepository(db: LocalDatabase): DBRepository {
        return DBRepository(dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCase(
        dbRepository: DBRepository,
        apiRepository: APIRepository
    ): UseCase =
        UseCase(
            // db use case
            getAllSMSObserveUC = GetAllSMSObserveUC(dbRepository),
            insertSMSObserveUC = InsertSMSObserveUC(dbRepository),
            // api use case
            callAPIAfterReceiveSMSUC = CallAPIAfterReceiveSMSUC(apiRepository, dbRepository),
            getAllSMSObserveBySenderUC = GetAllSMSObserveBySenderUC(dbRepository)
        )
}