package com.studio.mattiaferigutti.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNumber = 0f
    private var oldNumber = 0f
    private var operation = ""
    private var previousOperation = ""
    private var isNewOperation = false
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
        if (isNewOperation) {
            oldNumber = currentNumber
            numberInString = ""
        }
        isNewOperation = false

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
                operation = "+"
                total()
                previousOperation = "+"
            }
            R.id.minusButton -> {
                operation = "-"
                total()
                previousOperation = "-"
            }
            R.id.multiplyButton -> {
                operation = "*"
                total()
                previousOperation = "*"
            }
            R.id.divideButton -> {
                operation = "/"
                total()
                previousOperation = "/"
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

    private fun total() {
        if (oldNumber != 0f && currentNumber != 0f) {
            makeOperations(previousOperation)
        }
        isNewOperation = true
    }

    private fun makeOperations(operation: String) {
        var finalResult = 0f
        when (operation) {
            "+" -> {
                finalResult = oldNumber + currentNumber
            }
            "-" -> {
                finalResult = oldNumber - currentNumber
            }
            "*" -> {
                finalResult = oldNumber * currentNumber
            }
            "/" -> {
                finalResult = oldNumber / currentNumber
            }
        }
        currentNumber = finalResult
        numberInString = finalResult.toString()
    }

}