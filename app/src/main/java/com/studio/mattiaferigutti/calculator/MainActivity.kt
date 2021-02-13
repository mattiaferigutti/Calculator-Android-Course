package com.studio.mattiaferigutti.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.studio.mattiaferigutti.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNumber = 0f
    private var oldNumber = 0f
    private var operation = ""
    private var previousOperation = ""
    private var isNewOperation = false
    private var numberInString = ""
        get() = binding.numberText.text.toString()
        set(value) {
            binding.numberText.text = value
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
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
            R.id.percentageButton -> {
                operation = "%"
                total()
                previousOperation = operation
            }
            R.id.addButton -> {
                operation = "+"
                total()
                previousOperation = operation
            }
            R.id.minusButton -> {
                operation = "-"
                total()
                previousOperation = operation
            }
            R.id.multiplyButton -> {
                operation = "*"
                total()
                previousOperation = operation
            }
            R.id.divideButton -> {
                operation = "/"
                total()
                previousOperation = operation
            }
            R.id.pointButton -> {
                if (!numberInString.contains(".")) {
                    numberInString = "$numberInString."
                }
            }
            R.id.invertButton -> {
                invert()
            }
            R.id.cancelButton -> {
                cancel()
            }
            R.id.resultButton -> {
                result()
            }
        }
    }

    private fun cancel() {
        currentNumber = 0f
        oldNumber = 0f
        numberInString = "0"
    }

    private fun result() {
        makeOperations(operation)
        oldNumber = 0f
    }

    private fun invert() {
        var number = numberInString.toFloat()
        number *= -1 //number = number * -1
        currentNumber = number
        numberInString = number.toString()
    }

    private fun setNumber(number: Int) {
        numberInString = if (numberInString == "0" || numberInString == "0.0") {
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

    private fun calculatePercentage(fullNumber: Float, percentage: Float) =
        //x : fullNumber = percentage : 100
        (percentage * fullNumber) / 100

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
            "%" -> {
                finalResult = calculatePercentage(oldNumber, currentNumber)
            }
        }
        currentNumber = finalResult
        numberInString = finalResult.toString()
    }

}