package com.example.birthdate.ui.showinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowInfoViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val day = MutableLiveData<String>()
    val month = MutableLiveData<String>()
    val year = MutableLiveData<String>()
    val yearGhamari = MutableLiveData<String>()
    val selfDay = MutableLiveData<String>()
    val selfMonth = MutableLiveData<String>()
    val selfYear = MutableLiveData<String>()
    val season = MutableLiveData<String>()
    val yearName = MutableLiveData<String>()
    val MonthName = MutableLiveData<String>()
    val yearMiladi = MutableLiveData<String>()
    val  age = MutableLiveData<String>()

}