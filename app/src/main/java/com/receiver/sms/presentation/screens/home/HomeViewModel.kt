package com.receiver.sms.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.receiver.sms.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase,
) : ViewModel() {
    fun createSMSObserve() {

    }
}