package com.bignerdranch.android.hangman

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class GameManager {
    private lateinit var lettersUsed: String
    private lateinit var underscoreWord: String
    private lateinit var wordToGuess: String
    private val maxTries = 6
    private var currentTries = 0
    var drawable: Int = R.drawable.hangman0


    fun startNewGame(): GameState{
        lettersUsed = ""
        drawable = R.drawable.hangman6
        wordToGuess = WordViewModel.//
        return getGameState()
    }

    fun play(letter: Char) : GameState {
        if (lettersUsed.contains(letter))
            return GameState.Running(lettersUsed,drawable)
        lettersUsed += letter
        val indexes = mutableListOf<Int>()
        wordToGuess.forEachIndexed{index, char ->
            if(char.equals(letter,true))
                indexes.add(index)
        }
        if (indexes.isEmpty())
            currentTries++
        return getGameState()
    }

    private fun getHangmanDrawable(): Int {
        return when(currentTries) {
            0 -> R.drawable.hangman0
            1 -> R.drawable.hangman1
            2 -> R.drawable.hangman2
            3 -> R.drawable.hangman3
            4 -> R.drawable.hangman4
            5 -> R.drawable.hangman5
            6 -> R.drawable.hangman6
            else -> R.drawable.hangman6
        }
    }

    private fun getGameState() : GameState {
        if (underscoreWord.equals(wordToGuess,true))
            return GameState.Won(wordToGuess)
        if (currentTries == maxTries)
            return GameState.Lost(wordToGuess)
        drawable = getHangmanDrawable()
        return GameState.Running(lettersUsed,drawable)
    }

}