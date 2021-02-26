package com.example.birthdate.ui.addinfo

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.birthdate.datamodel.MainTableModel
import com.example.birthdate.datamodel.ResponseCurrencyData
import com.example.birthdate.localdb.DateRepository
import com.example.birthdate.network.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class AddInfoViewModel(
    private val apiRepository: ApiRepository,
    val app: Application
) : AndroidViewModel(app) {


    private val _responseCurrencyData = MutableLiveData<ResponseCurrencyData>()
    val responseCurrencyData: LiveData<ResponseCurrencyData>
        get() = _responseCurrencyData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    val day = MutableLiveData<String>()


    val month = MutableLiveData<String>()


    val year = MutableLiveData<String>()


    fun getCurrencyData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _responseCurrencyData.postValue(
                    apiRepository.getArzData(
                        year.value.toString(),
                        month.value.toString(),
                        day.value.toString()
                    )
                )
                Timber.e("ok")
            } catch (e: Exception) {
                Timber.e(e)
                _errorMessage.postValue(e.message)
            }
        }
    }

    fun insertData(
        mainTableModel: MainTableModel

    ) {
        DateRepository.insertData(
            app,
            mainTableModel
        )
    }
}