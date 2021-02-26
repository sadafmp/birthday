package com.example.birthdate.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Date")
data class MainTableModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "self_day")
    val selfDay: String,
    @ColumnInfo(name = "self_month")
    val selfMonth: String,
    @ColumnInfo(name = "self_year")
    val selfYear: String,

    @ColumnInfo(name = "birth_season")
    val birthSeason: String?,
    @ColumnInfo(name = "birthghamari")
    val birthghamari: String?,
    @ColumnInfo(name = "birthmiladi")
    val birthmiladi: String?,
    @ColumnInfo(name = "day")
    val day: String?,
    @ColumnInfo(name = "month")
    val month: String?,
    @ColumnInfo(name = "month_nemad")
    val monthNemad: String?,

    @ColumnInfo(name = "to_birth")
    val toBirth: String?,
    @ColumnInfo(name = "year")
    val year: String?,
    @ColumnInfo(name = "year_name")
    val yearName: String?

) : Serializable
