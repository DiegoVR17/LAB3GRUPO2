package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivityAreaTrianguloBinding

class area_triangulo : AppCompatActivity() {

    private lateinit var  mainBinding: ActivityAreaTrianguloBinding
    private lateinit var  mainViewModel: AreaTrianguloViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityAreaTrianguloBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[AreaTrianguloViewModel::class.java]

        val AreaTriangulo = Observer<Double> {resultado ->
            mainBinding.result.text = resultado.toString()
        }

        mainViewModel.result.observe(this,AreaTriangulo)

        mainBinding.calculate.setOnClickListener {
            mainViewModel.validateNumbers(mainBinding.baseTextInput.text.toString(),mainBinding.alturaTextInput.text.toString())

        }
    }
}