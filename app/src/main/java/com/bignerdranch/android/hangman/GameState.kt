package com.bignerdranch.android.hangman

open class GameState {
    class Running(
        val lettersUsed: String,
        val drawable: Int) : GameState()
    class Lost(val wordToGuess: String): GameState()
    class Won(val wordToGuess: String): GameState()

}
