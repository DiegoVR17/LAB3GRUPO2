package com.example.laboratorio3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val PSLengthSideObserver: MutableLiveData<String> = MutableLiveData()
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    fun calculatorPerimeterSquare(num: String){
        if(num.isEmpty()){
            _errorMsg.value = "Debe digitar un numero"
        }else{
            PSLengthSideObserver.value = (4* num.toDouble()).toString()
        }
    }


}