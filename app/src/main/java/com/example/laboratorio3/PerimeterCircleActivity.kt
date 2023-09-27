package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivityPerimeterCircleBinding

class PerimeterCircleActivity : AppCompatActivity() {
    private lateinit var perimeterCircleBinding:ActivityPerimeterCircleBinding
    // Declarar el ViewModel con el de CircleAreaViewModel
    private lateinit var perimeterCircleViewModel:PerimeterCircleViewModel
    //onclick
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perimeterCircleBinding = ActivityPerimeterCircleBinding.inflate(layoutInflater)
        val view = perimeterCircleBinding.root
        setContentView(view)

        // inicilizar el viewModel
        perimeterCircleViewModel = ViewModelProvider(this)[PerimeterCircleViewModel::class.java]

        // Observador para Area
        val perimeterCircleObserver = Observer<String> {perimetro->
            perimeterCircleBinding.resultCirclePerimeterTextView.setText(perimetro)}

        // Poner observador Area
        perimeterCircleViewModel.perimeter.observe(this, perimeterCircleObserver)

        val errorMesaggeObserver = Observer<String> {errorMesagge ->
            Toast.makeText(this, errorMesagge, Toast.LENGTH_LONG).show()}
        perimeterCircleViewModel.errorMessage.observe(this, errorMesaggeObserver)

        // escuchar el Touch del boton circleAreaButtonCalculate
        perimeterCircleBinding.circlePerimeterButtonCalculate.setOnClickListener{
            perimeterCircleViewModel.validateInput(perimeterCircleBinding.valueCiclePerimeterEditText.text.toString())

        }
    }
}