package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivityMainBinding
import com.example.laboratorio3.databinding.ActivityPerimeterSquareBinding
import com.google.android.material.snackbar.Snackbar

class PerimeterSquareActivity : AppCompatActivity() {

    private lateinit var perimeterSquareBinding: ActivityPerimeterSquareBinding
    private lateinit var perimeterSquareViewModel: PerimeterSquareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perimeterSquareBinding = ActivityPerimeterSquareBinding.inflate(layoutInflater)
        val view = perimeterSquareBinding.root
        setContentView(view)

        perimeterSquareViewModel = ViewModelProvider(this)[PerimeterSquareViewModel::class.java]

        val perimeterSquare = Observer<Double> {resultado ->
            perimeterSquareBinding.PSResultTextView.text = resultado.toString()
        }
        perimeterSquareViewModel.result.observe(this,perimeterSquare)

        val errorMsgObserver = Observer<String>{errorMsg->
            Snackbar.make(view, errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("aceptar"){}
                .show()
        }

        perimeterSquareBinding.PSCalculatorButton.setOnClickListener {
            perimeterSquareViewModel.validateNumbers(perimeterSquareBinding.PSLengthSideEditText.text.toString())

        }

    }

}