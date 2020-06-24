package com.medcords.sample.network

import com.medcords.sample.network.models.BaseResponse
import com.medcords.sample.network.models.ListEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    private const val TIME_OUT = 30

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun httpClient() = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .build()

    private val apiClient = Retrofit.Builder().baseUrl(DataService.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient()).build()
        .create(DataService::class.java)

    suspend fun getMedList(): List<BaseResponse<ListEntity>> = apiClient.getMedList()
}