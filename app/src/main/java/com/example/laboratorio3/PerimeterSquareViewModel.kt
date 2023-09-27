package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class PerimeterSquareViewModel : ViewModel() {
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    val result : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    fun validateNumbers(input: String) {
        if(input.isEmpty()){
            _errorMsg.value = "Debe digitar dos numeros"
        }else{
            val side = input.toDouble()
            val perimeter = 4*side
            result.value =perimeter
        }
    }

}

