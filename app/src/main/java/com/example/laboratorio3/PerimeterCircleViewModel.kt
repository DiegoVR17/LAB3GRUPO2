package com.example.laboratorio3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class PerimeterCircleViewModel:ViewModel() {
    // crear LiveData
    val perimeter: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun validateInput(inputPerimeter: String) {
        if(inputPerimeter.isEmpty()) {
            errorMessage.value = "Ingrese un numero para calcular perimetro"
        }
        else {
            var perimeterOne = (2 * 3.1416 * inputPerimeter.toDouble()).toString()
            perimeterOne = String.format("%.2f", perimeterOne.toDouble())
            perimeter.value = perimeterOne
        }

    }
}