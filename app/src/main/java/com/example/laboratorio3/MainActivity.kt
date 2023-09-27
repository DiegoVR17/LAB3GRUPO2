/*Luis Fernando Torres
App Perimetro del circuilo
*/

package com.example.laboratorio3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.PerimeterCircleButton.setOnClickListener {
            val intent = Intent(this,PerimeterCircleActivity::class.java)
            startActivity(intent)
        }


    }
}