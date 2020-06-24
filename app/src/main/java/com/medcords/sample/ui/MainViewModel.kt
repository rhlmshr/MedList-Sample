package com.medcords.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.medcords.sample.network.models.ResponseState

class MainViewModel : ViewModel() {
    private val repo by lazy { MainRepo }

    val medsLiveData = liveData {
        emit(ResponseState.Loading)
        emit(repo.getMedList().data)
    }
}