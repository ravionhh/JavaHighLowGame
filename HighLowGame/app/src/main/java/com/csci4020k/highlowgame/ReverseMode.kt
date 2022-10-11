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

class ReverseMode : AppCompatActivity(){
    private lateinit var ivCard1: ImageView
    private lateinit var ivCard2: ImageView

    private lateinit var tvPlayer1: TextView
    private lateinit var tvPlayer2: TextView

    private lateinit var dealButton: Button

    private lateinit var random: Random

    private var player1 = 0
    private var player2 = 0

    private lateinit var newGameButton: Button


    private var cardsArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.hearts3,
        R.drawable.hearts4,
        R.drawable.hearts5,
        R.drawable.hearts6,
        R.drawable.hearts7,
        R.drawable.hearts8,
        R.drawable.hearts9,
        R.drawable.hearts10,
        R.drawable.hearts12,
        R.drawable.hearts13,
        R.drawable.hearts14,
        R.drawable.hearts15
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)

        random = Random

        //init objects
        ivCard1 = findViewById(R.id.ivCard1)
        ivCard2 = findViewById(R.id.ivCard2)

        ivCard1.setImageResource(R.drawable.card_back)
        ivCard2.setImageResource(R.drawable.card_back)

        tvPlayer1 = findViewById(R.id.tvPlayer1)
        tvPlayer2 = findViewById(R.id.tvPlayer2)

        //startNewGame Button
        newGameButton = findViewById(R.id.newGameButton)
        newGameButton.visibility = View.INVISIBLE

        newGameButton.setOnClickListener {
            startNewGame()
        }
        //Toast to user the directions
        Toast.makeText(this, R.string.reverse, Toast.LENGTH_LONG)
            .show()

        dealButton = findViewById(R.id.dealButton)
        dealButton.setOnClickListener {
            //generate cards
            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)

            //set images
            setCardImage(card1, ivCard1)
            setCardImage(card2, ivCard2)

            //compare the cards
            if (card1 < card2) {
                player1++
                tvPlayer1.text = "Player 1: $player1"
            } else if (card1 > card2) {
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