package com.example.birthdate.network

import com.example.birthdate.datamodel.ResponseCurrencyData


interface ApiRepository {
    suspend fun getArzData(
        year: String,
        month: String,
        day: String,
    ): ResponseCurrencyData
}
