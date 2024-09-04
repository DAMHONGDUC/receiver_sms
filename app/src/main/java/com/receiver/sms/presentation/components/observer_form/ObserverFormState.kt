package com.receiver.sms.presentation.components.observer_form

sealed class ObserverFormEvent {
    data class ObserverSenderChanged(val observerSender: String) : ObserverFormEvent()
    data class BodyChanged(val body: String) : ObserverFormEvent()
    data class EndPointChanged(val endPoint: String) : ObserverFormEvent()
    data class HeaderChanged(val header: String) : ObserverFormEvent()
    data class ParamsChanged(val params: String) : ObserverFormEvent()
    object Submit : ObserverFormEvent()
}
