package com.vinay.vymoassignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinay.vymoassignment.data.models.Input

class InputRepoDetailsViewModel : ViewModel() {
    val message = MutableLiveData<Input>()

    fun setMsgCommunicator(msg:Input){
        message.value = msg
    }
}