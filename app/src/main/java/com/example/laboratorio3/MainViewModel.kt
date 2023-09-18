package com.example.laboratorio3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel()  {

    val perimeter: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val reset: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg


    fun calculatePerimeter(L1: String, L2: String,L3: String) {

        if ((L1.isEmpty()) || (L2.isEmpty()) || (L3.isEmpty()) || (L1 == " ") || (L2 == " ") || (L3 == " ") ){
            _errorMsg.value = "Debe escribir todos los lados del triángulo"
        }
        else{
            val perimeterValue = L1.toDouble() + L2.toDouble() + L3.toDouble()
            perimeter.value = perimeterValue.toString()
        }
    }

    fun reset() {
        reset.value = " "
        perimeter.value = " "
    }

}