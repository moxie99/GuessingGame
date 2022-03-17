package com.oluwasegun.guesstheevennumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var screenLayout: ConstraintLayout
    @SuppressLint("ResourceAsColor")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        screenLayout = findViewById(R.id.backgroundCL)



        assignRandomNumbers()
        btnLeft.setOnClickListener {
            assignRandomNumbers()
            checkAnswer(true)

        }
        btnRight.setOnClickListener {
            assignRandomNumbers()
            checkAnswer(false)

        }

    }



    @SuppressLint("ResourceAsColor")
    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        var leftValue = btnLeft.text.toString().toInt()
        var rightValue = btnRight.text.toString().toInt()

        var isAnswerRight: Boolean = if (isLeftButtonSelected) leftValue > rightValue else rightValue > leftValue

        if(isAnswerRight){
            screenLayout.setBackgroundColor(R.color.purple_200)
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()

        }else{
            screenLayout.setBackgroundColor(R.color.purple_500)
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
        }
    }

    private fun assignRandomNumbers() {
        val r = Random
        val leftNum = r.nextInt(50)
        var rightNum = leftNum
        while(rightNum == leftNum){
            rightNum = r.nextInt(50)
        }
        btnRight.text = rightNum.toString()
        btnLeft.text = leftNum.toString()
    }
}