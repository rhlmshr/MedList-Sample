package com.medcords.sample.network

import com.medcords.sample.network.models.BaseResponse
import com.medcords.sample.network.models.ListEntity
import retrofit2.http.GET
import retrofit2.http.POST

interface DataService {

    @GET("mhc/test_get_cc")
    suspend fun getMedList(): BaseResponse<List<ListEntity>>

    companion object {
        const val API_URL = "https://webserver-dev1.medcords.com/"
    }
}