package com.medcords.sample.ui

import com.medcords.sample.network.ApiService
import com.medcords.sample.network.models.ResponseState

object MainRepo {
    suspend fun getMedList() = ApiService.getMedList()
}