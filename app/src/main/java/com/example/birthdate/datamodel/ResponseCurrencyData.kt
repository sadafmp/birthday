package com.example.birthdate.datamodel


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCurrencyData(
    @Json(name = "ok")
    val ok: Boolean?,
    @Json(name = "result")
    val result: Result?
) : Parcelable