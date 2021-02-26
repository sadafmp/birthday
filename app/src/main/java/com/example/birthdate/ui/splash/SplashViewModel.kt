package com.example.birthdate.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _evenFinishTimer = MutableLiveData(false)
    val evenFinishTimer: LiveData<Boolean>
        get() = _evenFinishTimer

    init {
        startTimer()
    }

    private fun startTimer() {

        Handler(Looper.getMainLooper()).postDelayed({
            _evenFinishTimer.value = true
        }, 4000)
    }
}