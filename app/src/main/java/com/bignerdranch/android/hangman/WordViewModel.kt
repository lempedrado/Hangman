package com.bignerdranch.android.hangman

import android.content.Context
import android.provider.Settings.System.getString
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class WordViewModel : ViewModel(){

    private val wordBank = listOf(
        Word(R.string.absurd),
        Word(R.string.avenue),
        Word(R.string.emboss),
        Word(R.string.frivolous),
        Word(R.string.fulfill),
        Word(R.string.luxury),
        Word(R.string.marquis),
        Word(R.string.topaz)
    )

    private val wordBankSize = wordBank.size

    private var currentIndex = Random.nextInt(0,wordBankSize)

    val currentWordText: Int
        get() = wordBank[currentIndex].textResId


    fun moveToNext(){
        currentIndex = (currentIndex + 1) % wordBank.size
    }
}
