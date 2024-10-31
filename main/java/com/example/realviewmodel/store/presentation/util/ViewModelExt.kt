package com.example.realviewmodel.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realviewmodel.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvents(event:Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}