package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio3.databinding.ActivityMainBinding
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val perimeterObserver = Observer<String>{result ->
            mainBinding.textViewResult.text = result
        }

        mainViewModel.perimeter.observe(this,perimeterObserver)

        val errorMsgObserver = Observer<String>{errorMsg ->
            Snackbar.make(view,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Continuar"){}
                .show()
        }
        mainViewModel.errorMsg.observe(this,errorMsgObserver)

        mainBinding.buttonCalcu.setOnClickListener {
            mainViewModel.calculatePerimeter(mainBinding.TextInputEditTextL1.text.toString(),
                mainBinding.TextInputEditTextL2.text.toString(),
                mainBinding.TextInputEditTextL3.text.toString())
        }

    }


}