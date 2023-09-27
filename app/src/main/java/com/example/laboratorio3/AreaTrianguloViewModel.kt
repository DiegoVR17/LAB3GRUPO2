package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AreaTrianguloViewModel : ViewModel() {

    val result : MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }
    fun validateNumbers(base: String, altura: String) {
        if(base.isEmpty() || altura.isEmpty()){
            result.value = 0.0
        }else{
            result.value = (base.toDouble() * altura.toDouble())/2
        }
    }

}