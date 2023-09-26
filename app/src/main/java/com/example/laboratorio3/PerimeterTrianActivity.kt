package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivityMainBinding
import com.example.laboratorio3.databinding.ActivityPerimeterTrianBinding
import com.google.android.material.snackbar.Snackbar

class PerimeterTrianActivity : AppCompatActivity() {

    private lateinit var perimeterTrianBinding: ActivityPerimeterTrianBinding
    private lateinit var perimeterTrianViewModel: PerimeterTrianViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perimeterTrianBinding = ActivityPerimeterTrianBinding.inflate(layoutInflater)
        setContentView(perimeterTrianBinding.root)

        perimeterTrianViewModel = ViewModelProvider(this)[PerimeterTrianViewModel::class.java]

        val perimeterObserver = Observer<String>{result ->
            perimeterTrianBinding.textViewResult.text = result
        }

        perimeterTrianViewModel.perimeter.observe(this,perimeterObserver)

        val resetObserver = Observer<String>{reset ->
            perimeterTrianBinding.TextInputEditTextL1.setText(reset)
            perimeterTrianBinding.TextInputEditTextL2.setText(reset)
            perimeterTrianBinding.TextInputEditTextL3.setText(reset)
        }

        perimeterTrianViewModel.reset.observe(this,resetObserver)

        val errorMsgObserver = Observer<String>{errorMsg ->
            Snackbar.make(perimeterTrianBinding.root,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Continuar"){}
                .show()
        }


        perimeterTrianViewModel.errorMsg.observe(this,errorMsgObserver)

        perimeterTrianBinding.buttonCalcu.setOnClickListener {
            perimeterTrianViewModel.calculatePerimeter(perimeterTrianBinding.TextInputEditTextL1.text.toString(),
                perimeterTrianBinding.TextInputEditTextL2.text.toString(),
                perimeterTrianBinding.TextInputEditTextL3.text.toString())
        }

        perimeterTrianBinding.buttonReset.setOnClickListener {
            perimeterTrianViewModel.reset()
        }
    }
}