package com.medcords.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medcords.sample.network.models.Cm
import com.medcords.sample.network.models.ResponseState

class MainViewModel : ViewModel() {
    private val repo by lazy { MainRepo }

    private val _postsLiveData = MutableLiveData<ResponseState<List<Cm>>>()

    val postsLiveData: LiveData<ResponseState<List<Cm>>>
        get() = _postsLiveData

    fun getData() {
        postsLiveData = liveData {
            emit(ResponseState.Loading)
        }
    }

    private fun getMedList() {
        repo.
    }
}