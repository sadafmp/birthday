package com.example.birthdate.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.birthdate.datamodel.MainTableModel
import com.example.birthdate.utils.Converters

@Database(entities = arrayOf(MainTableModel::class), version = 1, exportSchema = false)
    @TypeConverters(Converters::class)
    abstract class DateDataBase : RoomDatabase() {

        abstract fun dao(): DaoAccess

        companion object {

            @Volatile
            private var INSTANCE: DateDataBase? = null

            fun getDataClient(context: Context): DateDataBase {

                if (INSTANCE != null) return INSTANCE!!

                synchronized(this) {

                    INSTANCE = Room
                        .databaseBuilder(context, DateDataBase::class.java, "DATABASE")
                        .fallbackToDestructiveMigration()
                        .build()

                    return INSTANCE!!

                }
            }
        }
}