package com.bignerdranch.android.hangman

import androidx.annotation.StringRes

data class Word (@StringRes val textResId: Int, )
{
    fun getString() : String{
        return this.context()
    }
}