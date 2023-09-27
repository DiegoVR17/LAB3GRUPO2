package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivitySquareAreaBinding



class SquareAreaActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivitySquareAreaBinding
    private lateinit var areasquareMVVM: AreaSquareMVVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivitySquareAreaBinding.inflate(layoutInflater)
        var view=mainBinding.root
        setContentView(view)

        areasquareMVVM= ViewModelProvider(this)[AreaSquareMVVM::class.java]

        val resulObserver= Observer<Double>{
                resul_operation ->mainBinding.textviewResultAreaSquare.setText(resul_operation.toString())

        }
        areasquareMVVM.result_operation.observe(this,resulObserver)


        mainBinding.buttonAreaSquare.setOnClickListener {
            areasquareMVVM.Area_squeare(mainBinding.setTextAreaSquare.text.toString().toDouble())
        }

    }
}