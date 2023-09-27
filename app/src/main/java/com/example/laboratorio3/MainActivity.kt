/*Luis Fernando Torres
App Perimetro del circuilo
*/

package com.example.laboratorio3

import android.app.Activity
import android.content.Intent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio3.databinding.ActivityMainBinding
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

        mainBinding.PerimeterCircleButton.setOnClickListener {
            val intent = Intent(this,PerimeterCircleActivity::class.java)
            startActivity(intent)
        }


     
        

        mainBinding.buttonPerimeter.setOnClickListener {
            val intent = Intent(this,PerimeterTrianActivity::class.java)
            startActivity(intent)
        }

       

        mainBinding.PSButton.setOnClickListener {
            val intent: Intent = Intent (this , PerimeterSquareActivity::class.java)
            startActivity(intent)
        }

        mainBinding.buttonSquareArea.setOnClickListener {
            val intent = Intent(this,SquareAreaActivity::class.java)
            startActivity(intent)
        }

    }
}
