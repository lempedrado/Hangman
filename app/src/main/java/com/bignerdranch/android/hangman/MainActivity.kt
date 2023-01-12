package com.bignerdranch.android.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var gameName: TextView

    private lateinit var aButton: Button
    private lateinit var bButton: Button
    private lateinit var cButton: Button
    private lateinit var dButton : Button
    private lateinit var eButton : Button
    private lateinit var fButton : Button
    private lateinit var gButton : Button
    private lateinit var hButton : Button
    private lateinit var iButton : Button
    private lateinit var jButton : Button
    private lateinit var kButton : Button
    private lateinit var lButton : Button
    private lateinit var mButton : Button
    private lateinit var nButton : Button
    private lateinit var oButton : Button
    private lateinit var pButton : Button
    private lateinit var qButton : Button
    private lateinit var rButton : Button
    private lateinit var sButton : Button
    private lateinit var tButton : Button
    private lateinit var uButton : Button
    private lateinit var vButton : Button
    private lateinit var wButton : Button
    private lateinit var xButton : Button
    private lateinit var yButton : Button
    private lateinit var zButton : Button

    private lateinit var newGameButton: Button

    private lateinit var blankTextView: TextView

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this)[WordViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameName = findViewById(R.id.game_name)
        blankTextView = findViewById(R.id.word)

        aButton = findViewById(R.id.a_button)
        bButton = findViewById(R.id.b_button)
        cButton = findViewById(R.id.c_button)
        dButton =findViewById(R.id.d_button)
        eButton = findViewById(R.id.e_button)
        fButton = findViewById(R.id.f_button)
        gButton = findViewById(R.id.g_button)
        hButton = findViewById(R.id.h_button)
        iButton = findViewById(R.id.i_button)
        jButton = findViewById(R.id.j_button)
        kButton = findViewById(R.id.k_button)
        lButton = findViewById(R.id.l_button)
        mButton = findViewById(R.id.m_button)
        nButton = findViewById(R.id.n_button)
        oButton = findViewById(R.id.o_button)
        pButton = findViewById(R.id.p_button)
        qButton = findViewById(R.id.q_button)
        rButton = findViewById(R.id.r_button)
        sButton = findViewById(R.id.s_button)
        tButton = findViewById(R.id.t_button)
        uButton = findViewById(R.id.u_button)
        vButton = findViewById(R.id.v_button)
        wButton = findViewById(R.id.w_button)
        xButton = findViewById(R.id.x_button)
        yButton = findViewById(R.id.y_button)
        zButton = findViewById(R.id.z_button)

        newGameButton = findViewById(R.id.newGameButton)
        newGameButton.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

        aButton.setOnClickListener {
            findLetter('a')
        }

        bButton.setOnClickListener {
            findLetter('b')
        }

        cButton.setOnClickListener {
            findLetter('c')
        }

        dButton.setOnClickListener {
            findLetter('d')
        }

        eButton.setOnClickListener {
            findLetter('e')
        }

        fButton.setOnClickListener {
            findLetter('f')
        }

        gButton.setOnClickListener {
            findLetter('q')
        }

        hButton.setOnClickListener {
            findLetter('h')
        }

        iButton.setOnClickListener {
            findLetter('i')
        }

        jButton.setOnClickListener {
            findLetter('j')
        }

        kButton.setOnClickListener {
            findLetter('k')
        }

        lButton.setOnClickListener {
            findLetter('l')
        }

        mButton.setOnClickListener {
            findLetter('m')
        }

        nButton.setOnClickListener {
            findLetter('n')
        }

        oButton.setOnClickListener {
            findLetter('o')
        }

        pButton.setOnClickListener {
            findLetter('p')
        }

        qButton.setOnClickListener {
            findLetter('q')
        }

        rButton.setOnClickListener {
            findLetter('r')
        }

        sButton.setOnClickListener {
            findLetter('s')
        }

        tButton.setOnClickListener {
            findLetter('t')
        }

        uButton.setOnClickListener {
            findLetter('u')
        }

        vButton.setOnClickListener {
            findLetter('v')
        }

        wButton.setOnClickListener {
            findLetter('w')
        }

        xButton.setOnClickListener {
            findLetter('x')
        }

        yButton.setOnClickListener {
            findLetter('y')
        }

        zButton.setOnClickListener {
            findLetter('z')
        }

        updateQuestion()

    }

    private fun updateQuestion(){
        blankTextView.text = getBlanks()
    }

    fun getBlanks() : String
    {
        var blankString = ""
        for(c: Char in getString(wordViewModel.currentWordText).lowercase().toCharArray()){
        if(c.isLetter())
            blankString += "_"
        else if (c == ' ')
            blankString += "/"
        }
        return blankString
    }

    private fun findLetter(c:Char){
        val word = getString(wordViewModel.currentWordText)
        var blankString = ""
        for(char: Char in word.lowercase().toCharArray()){
            if(char == c)
                blankString += c
            else if (char.isLetter())
                blankString += "_"
            else if (char == ' ')
                blankString += "/"
        }
        blankTextView.text = blankString
    }

}