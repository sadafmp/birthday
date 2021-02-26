package com.example.birthdate.localdb

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.birthdate.datamodel.MainTableModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DateRepository {

    companion object {

        var dateDataBase: DateDataBase? = null

        var mainTableModel: LiveData<List<MainTableModel>>? = null

        fun initializeDB(context: Context): DateDataBase {
            return DateDataBase.getDataClient(context)
        }

        fun insertData(
            context: Context,
            mainTableModel: MainTableModel

            ) {

            dateDataBase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val loginDetails = mainTableModel
                dateDataBase!!.dao().insertData(loginDetails)
            }

        }

        fun updateData(
            context: Context,
            mainTableModel: MainTableModel,
        ) {

            dateDataBase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                dateDataBase!!.dao().updateData(mainTableModel)
            }

        }

        fun deleteData(
            context: Context,
            mainTableModel: MainTableModel,
        ) {

            dateDataBase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                dateDataBase!!.dao().delete(mainTableModel)
            }

        }


        fun getAll(
            context: Context,
        ): LiveData<List<MainTableModel>>? {

            dateDataBase = initializeDB(context)

            mainTableModel == dateDataBase!!.dao().getAll()

            return mainTableModel
        }

    }
}