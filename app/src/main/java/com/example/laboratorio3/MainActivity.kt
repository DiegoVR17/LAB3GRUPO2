package com.example.laboratorio3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding=ActivityMainBinding.inflate(layoutInflater)
        var view=mainBinding.root
        setContentView(view)

        mainBinding.buttonSquareArea.setOnClickListener {
            val intent = Intent(this,SquareAreaActivity::class.java)
            startActivity(intent)
        }

    }
}