package com.bignerdranch.android.hangman


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class GameActivity : AppCompatActivity() {
    private val gameFunctionality = GameManager()

    private lateinit var wordTextView: TextView
    private lateinit var lettersUsedTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var gameEndTextView: TextView
    private lateinit var newGameButton: Button
    private lateinit var lettersLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.initial)
        wordTextView = findViewById(R.id.word)
        lettersUsedTextView = findViewById(R.id.lettersUsed)
        gameEndTextView = findViewById(R.id.gameEnd)
        newGameButton = findViewById(R.id.newGameButton)
        lettersLayout = findViewById(R.id.lettersLayout)

        newGameButton.setOnClickListener {
            startNewGame()
        }

        val gameSetup = gameFunctionality.startNewGame()
        updateUI(gameSetup)

    }

    private fun updateUI(gameSetup:GameState){
        when(gameSetup){
            is GameState.Lost-> showGameLost(gameSetup.wordToGuess)
            is GameState.Running -> {
                wordTextView.text = getBlanks()
                lettersUsedTextView.text = "Letters used:${gameSetup.lettersUsed}"
                imageView.setImageDrawable(ContextCompat.getDrawable(this,gameSetup.drawable))
            }
            is GameState.Won -> showGameWon(gameSetup.wordToGuess)
        }
    }

    fun getBlanks(s : String) : String
    {
        var blankString = ""
        for(c: Char in s.lowercase().toCharArray()){
            if(c.isLetter())
                blankString += "_"
            else if (c == ' ')
                blankString += "/"
        }
        return blankString
    }

    private fun showGameLost(wordToGuess:String){
        wordTextView.text = wordToGuess
        gameEndTextView.text = "You Lost!"
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hangman6))
        lettersLayout.visibility = View.GONE
    }

    private fun showGameWon(wordToGuess: String){
        wordTextView.text = wordToGuess
        gameEndTextView.text = "You Won!"
        lettersLayout.visibility = View.GONE
    }

    private fun startNewGame() {
        gameEndTextView.visibility = View.GONE
        val gameSetup = gameFunctionality.startNewGame()
        lettersLayout.visibility = View.VISIBLE
        updateUI(gameSetup)
    }
}