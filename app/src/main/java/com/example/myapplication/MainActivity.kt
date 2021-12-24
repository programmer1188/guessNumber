package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        assignNewNumbers()
        binding.button1.setOnClickListener {

            checkNumbers(true)

            assignNewNumbers()

        }

        binding.button2.setOnClickListener{

            checkNumbers(false)

            assignNewNumbers()

        }

        }

    private fun checkNumbers(isLeftButtonSelected: Boolean){

        val leftNum:Int = binding.button1.text.toString().toInt()
        val rightNum:Int = binding.button2.text.toString().toInt()

        //compare both numbers
        val isAnswerCorrect: Boolean = if(isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if(isAnswerCorrect){
            binding.background.setBackgroundColor(Color.GREEN)
            Toast.makeText(applicationContext, "correct", Toast.LENGTH_SHORT).show()
        }else{
            binding.background.setBackgroundColor(Color.RED)
            Toast.makeText(applicationContext, "wrong", Toast.LENGTH_SHORT).show()
        }
    }

    //generate random numbers
    private fun assignNewNumbers() {
        val r = Random()
        val leftNum:Int = r.nextInt(100)
        var rightNum:Int = leftNum
        while(leftNum == rightNum){
            rightNum = r.nextInt(100)
        }

        binding.button1.text = leftNum.toString()
        binding.button2.text = rightNum.toString()
    }
}
