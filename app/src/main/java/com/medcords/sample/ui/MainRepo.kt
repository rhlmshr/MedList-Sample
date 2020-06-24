package com.medcords.sample.ui

import com.medcords.sample.network.ApiService

object MainRepo {

    fun getMedList() {
        ApiService.getMedList()
    }
}