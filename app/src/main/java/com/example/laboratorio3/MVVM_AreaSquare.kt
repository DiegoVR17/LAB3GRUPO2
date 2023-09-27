package com.example.laboratorio3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVM_AreaSquare:ViewModel()  {
    val result_operation: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    fun Area_squeare(side: Double){
        var result_area_squeare=side*side
        result_operation.value=result_area_squeare
    }
}