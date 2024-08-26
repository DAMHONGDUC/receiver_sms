package com.receiver.sms.core.di

import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.data.data_source.remote.APIService
import com.receiver.sms.data.repository.APIRepository
import com.receiver.sms.data.repository.DBRepository
import com.receiver.sms.domain.use_case.CallAPIAfterReceiveSMSUseCase
import com.receiver.sms.domain.use_case.GetAllSMSObserveUseCase
import com.receiver.sms.domain.use_case.GetReceiverSMSUseCase
import com.receiver.sms.domain.use_case.InsertReceiverSMSUseCase
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
    fun provideDBRepository(db: LocalDatabase): DBRepository {
        return DBRepository(dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideAPIRepository(apiService: APIService): APIRepository {
        return APIRepository(apiService = apiService)
    }

    @Provides
    @Singleton
    fun provideUseCase(
        dbRepository: DBRepository,
        apiRepository: APIRepository
    ): UseCase =
        UseCase(
            // db use case
            getAllSMSObserveUC = GetAllSMSObserveUseCase(dbRepository),
            insertSMSObserveUC = InsertSMSObserveUseCase(dbRepository),
            getReceiverSMSUC = GetReceiverSMSUseCase(dbRepository),
            insertReceiverSMSUC = InsertReceiverSMSUseCase(dbRepository),
            // api use case
            callAPIAfterReceiveSMSUC = CallAPIAfterReceiveSMSUseCase(apiRepository),
        )
}