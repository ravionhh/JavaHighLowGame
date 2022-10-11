package com.csci4020k.highlowgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import highlowgame.R

class CategoryActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val twoPlayersButton: Button = findViewById(R.id.twoPlayersButton)
        val threePlayersButton: Button = findViewById(R.id.threePlayersButton)
        val highLowButton: Button = findViewById(R.id.highLowButton)
        val reverseButton: Button = findViewById(R.id.reverseButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        twoPlayersButton.setOnClickListener {
            val twoPlayersIntent = Intent(this, TwoPlayerActivity::class.java)
            startActivity(twoPlayersIntent)
        }

        threePlayersButton.setOnClickListener {
            val threePlayersIntent = Intent(this, ThreePlayerActivity::class.java)
            startActivity(threePlayersIntent)
        }

        highLowButton.setOnClickListener {
            val highLowIntent = Intent(this, HighLowActivity::class.java)
            startActivity(highLowIntent)
        }

        reverseButton.setOnClickListener {
            val reverseIntent = Intent(this, ReverseMode::class.java)
            startActivity(reverseIntent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }


    }



}