package com.receiver.sms.core.di

import com.receiver.sms.data.data_source.local.LocalDatabase
import com.receiver.sms.data.data_source.remote.APIService
import com.receiver.sms.data.repositories_impl.SMSObserveRepositoryImpl
import com.receiver.sms.data.repositories_impl.SubmitSMSRepositoryImpl
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
    fun provideSMSObserveRepository(db: LocalDatabase): SMSObserveRepositoryImpl {
        return SMSObserveRepositoryImpl(dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideSubmitSMSRepository(apiService: APIService): SubmitSMSRepositoryImpl {
        return SubmitSMSRepositoryImpl(apiService = apiService)
    }

    @Provides
    @Singleton
    fun provideUseCase(
        smsObserveRepository: SMSObserveRepositoryImpl,
        submitSMSRepository: SubmitSMSRepositoryImpl
    ): UseCase =
        UseCase(
            // db use case
            getAllSMSObserveUC = GetAllSMSObserveUC(smsObserveRepository),
            insertSMSObserveUC = InsertSMSObserveUC(smsObserveRepository),
            // api use case
            callAPIAfterReceiveSMSUC = CallAPIAfterReceiveSMSUC(
                smsObserveRepository,
                submitSMSRepository,
            ),
            getAllSMSObserveBySenderUC = GetAllSMSObserveBySenderUC(smsObserveRepository)
        )
}