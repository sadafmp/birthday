package com.example.birthdate.network

import com.example.birthdate.datamodel.ResponseCurrencyData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/age/?")
    suspend fun getCurrencyData(
        @Query("year") year: String,
        @Query("month") month: String,
        @Query("day") day: String,
    ): ResponseCurrencyData
}