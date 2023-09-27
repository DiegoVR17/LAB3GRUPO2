package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivitySquareAreaBinding

class SquareAreaActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivitySquareAreaBinding
    private lateinit var mvvm_areaSquare: MVVM_AreaSquare
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivitySquareAreaBinding.inflate(layoutInflater)
        var view=mainBinding.root
        setContentView(view)

        mvvm_areaSquare= ViewModelProvider(this)[MVVM_AreaSquare::class.java]

        val resulObserver= Observer<Double>{
                resul_operation ->mainBinding.textviewResultAreaSquare.setText(resul_operation.toString())

        }
        mvvm_areaSquare.result_operation.observe(this,resulObserver)


        mainBinding.buttonAreaSquare.setOnClickListener {
            mvvm_areaSquare.Area_squeare(mainBinding.setTextAreaSquare.text.toString().toDouble())
        }

    }
}