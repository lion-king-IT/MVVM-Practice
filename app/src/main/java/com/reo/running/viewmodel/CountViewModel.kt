package com.reo.running.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    //var counterB: Int = 0
    val counterB: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        counterB.value = 0
    }
}