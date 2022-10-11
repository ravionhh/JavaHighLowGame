package com.csci4020k.highlowgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import highlowgame.R
import kotlin.random.Random

class HighLowActivity : AppCompatActivity() {
    private lateinit var ivCard1: ImageView

    private lateinit var tvPlayer1: TextView
    private lateinit var tvPlayer2: TextView

    private lateinit var tvDirection: TextView

    private lateinit var dealButton: Button

    private lateinit var random: Random

    private var player1 = 0
    private var player2 = 0

    private lateinit var newGameButton: Button


    private var cardsArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.hearts2,
        R.drawable.hearts3,
        R.drawable.hearts4,
        R.drawable.hearts5,
        R.drawable.hearts6,
        R.drawable.hearts6,
        R.drawable.hearts7,
        R.drawable.hearts8,
        R.drawable.hearts8,
        R.drawable.hearts9,
        R.drawable.hearts10,
        R.drawable.hearts15,
        R.drawable.hearts15
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highlow)

        random = Random

        //init objects
        ivCard1 = findViewById(R.id.ivCard1)

        ivCard1.setImageResource(R.drawable.card_back)

        tvPlayer1 = findViewById(R.id.tvPlayer1)
        tvPlayer2 = findViewById(R.id.tvPlayer2)

        tvDirection = findViewById(R.id.tvDirection)
        tvDirection.visibility = View.VISIBLE

        //startNewGame Button
        newGameButton = findViewById(R.id.newGameButton)
        newGameButton.visibility = View.INVISIBLE

        newGameButton.setOnClickListener {
            startNewGame()
        }

        //toast to players positions
        Toast.makeText(this, R.string.player1Low, Toast.LENGTH_LONG)
            .show()
        Toast.makeText(this, R.string.player2High, Toast.LENGTH_LONG)
            .show()
        Toast.makeText(this, R.string.goodLuck, Toast.LENGTH_SHORT)
            .show()

        dealButton = findViewById(R.id.dealButton)
        dealButton.setOnClickListener {
            //hide war label
            tvDirection.visibility = View.INVISIBLE

            //generate cards
            val card1 = random.nextInt(cardsArray.size)

            //set images
            setCardImage(card1, ivCard1)

            //sort cards
            if (card1 <= 6) {
                player1++
                tvPlayer1.text = "Player 1: $player1"
            }
            if (card1 >= 7) {
                player2++
                tvPlayer2.text = "Player 2: $player2"
            }

            if (player1 == 20) {
                newGameButton.visibility = View.VISIBLE
                tvPlayer1.text = "Player 1: Winner!"
            } else if (player2 == 20) {
                newGameButton.visibility = View.VISIBLE
                tvPlayer2.text = "Player 2: Winner!"
            }
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }

    private fun startNewGame(){
        if (player1 == 20) {
            val warIntent = Intent (this, CategoryActivity::class.java)
            startActivity(warIntent)
        } else if (player2 == 20) {
            val warIntent = Intent (this, CategoryActivity::class.java)
            startActivity(warIntent)
        }
    }
}
