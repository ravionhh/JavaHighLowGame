package com.csci4020k.highlowgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import highlowgame.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton: Button = findViewById(R.id.playButton)

        playButton.setOnClickListener {
            val categoryActivityIntent = Intent (this, CategoryActivity::class.java)
            startActivity(categoryActivityIntent)
        }
    }
}