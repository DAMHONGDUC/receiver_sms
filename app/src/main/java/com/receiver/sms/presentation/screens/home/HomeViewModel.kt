package com.receiver.sms.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.domain.use_case.UseCase
import com.receiver.sms.utils.view_model.ResultHandler
import com.receiver.sms.utils.view_model.ViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private val LOG_TAG = "HomeViewModelLOG"

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

    fun getAllSMSObserve() {
        try {
            viewModelScope.launch {
                val result = resultHandler.execute { useCase.getAllSMSObserveUC() }
                _listSMSObserver.value = result
            }
        } catch (e: Exception) {
            Log.e(LOG_TAG, e.toString())
        }

    }
}