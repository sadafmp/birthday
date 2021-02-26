package com.example.birthdate.datamodel


import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Result(
    @Json(name = "bathroom_hour")
    val bathroomHour: String?,
    @Json(name = "birth_day")
    val birthDay: String?,
    @Json(name = "birth_season")
    val birthSeason: String?,
    @Json(name = "birthghamari")
    val birthghamari: String?,
    @Json(name = "birthmiladi")
    val birthmiladi: String?,
    @Json(name = "day")
    val day: String?,
    @Json(name = "days")
    val days: String?,
    @Json(name = "eat_hour")
    val eatHour: String?,
    @Json(name = "eat_Kg")
    val eatKg: String?,
    @Json(name = "g_month")
    val gMonth: String?,
    @Json(name = "laughing")
    val laughing: String?,
    @Json(name = "Meal")
    val meal: String?,
    @Json(name = "month")
    val month: String?,
    @Json(name = "month_nemad")
    val monthNemad: String?,
    @Json(name = "Ordered")
    val ordered: String?,
    @Json(name = "Recreation")
    val recreation: String?,
    @Json(name = "sleep_time")
    val sleepTime: String?,
    @Json(name = "stone_month")
    val stoneMonth: String?,
    @Json(name = "to_birth")
    val toBirth: String?,
    @Json(name = "wc_hour")
    val wcHour: String?,
    @Json(name = "world_population")
    val worldPopulation: String?,
    @Json(name = "year")
    val year: String?,
    @Json(name = "year_name")
    val yearName: String?
) : Parcelable