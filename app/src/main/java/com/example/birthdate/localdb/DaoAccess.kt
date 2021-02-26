package com.example.birthdate.localdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.birthdate.datamodel.MainTableModel
@Dao
interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(mainTableModel: MainTableModel)

    @Update
    suspend fun updateData(mainTableModel: MainTableModel)

    @Delete
    suspend fun delete(mainTableModel: MainTableModel)

    @Query("SELECT * FROM date")
    fun getAll(): LiveData<List<MainTableModel>>
}