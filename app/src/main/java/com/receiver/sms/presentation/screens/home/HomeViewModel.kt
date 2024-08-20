package com.receiver.sms.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.domain.use_case.UseCase
import com.receiver.sms.utils.view_model.ResultHandler
import com.receiver.sms.utils.view_model.ViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase,
    private val resultHandler: ResultHandler,
) : ViewModel() {
    private val _listSMSObserver =
        MutableStateFlow<ViewModelState<List<SMSObserveModel>>>(ViewModelState.Empty)
    val listSMSObserver: StateFlow<ViewModelState<List<SMSObserveModel>>> = _listSMSObserver

    init {
        getAllSMSObserve()
    }

    fun createSMSObserve() {
        viewModelScope.launch {
            val status = useCase.insertSMSObserveUC(
                smsObserveEntity = SMSObserveEntity(
                    sender = "Hong Duc",
                    message = "Hello",
                    body = "body",
                    header = "Header"
                )
            )

            if (status) {
                getAllSMSObserve()
            }
        }

    }

    fun getAllSMSObserve() {
        viewModelScope.launch {
            val result = resultHandler.execute { useCase.getAllSMSObserveUC() }
            _listSMSObserver.value = result
        }

    }
}