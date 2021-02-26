package com.example.birthdate.network

import com.example.birthdate.datamodel.ResponseCurrencyData

class ApiRepositoryImp(private val apiService: ApiService) : ApiRepository {

    override suspend fun getArzData(
        year: String,
        month: String,
        day: String,
    ): ResponseCurrencyData {
        return apiService.getCurrencyData(year, month, day)
    }

}