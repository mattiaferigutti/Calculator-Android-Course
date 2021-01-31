package com.studio.mattiaferigutti.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNumber = 0f
    private var numberInString = ""
        get() = numberText?.text.toString()
        set(value) {
            numberText?.text = value
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onItemClick(view: View) {
        when (view.id) {
            R.id.button0 -> {
                setNumber(0)
            }
            R.id.button1 -> {
                setNumber(1)
            }
            R.id.button2 -> {
                setNumber(2)
            }
            R.id.button3 -> {
                setNumber(3)
            }
            R.id.button4 -> {
                setNumber(4)
            }
            R.id.button5 -> {
                setNumber(5)
            }
            R.id.button6 -> {
                setNumber(6)
            }
            R.id.button7 -> {
                setNumber(7)
            }
            R.id.button8 -> {
                setNumber(8)
            }
            R.id.button9 -> {
                setNumber(9)
            }
            R.id.addButton -> {

            }
            R.id.minusButton -> {

            }
            R.id.multiplyButton -> {

            }
            R.id.divideButton -> {

            }
            R.id.pointButton -> {

            }
            R.id.invertButton -> {

            }
        }
    }

    private fun setNumber(number: Int) {
        numberInString = if (numberInString == "0") {
            "$number"
        } else {
            "$numberInString$number"
        }

        currentNumber = numberInString.toFloat()
    }

}