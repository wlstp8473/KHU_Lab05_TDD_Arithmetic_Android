package com.example.arithmeticcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        // 덧셈
        buttonAdd.setOnClickListener {
            val numbers = getNumbers(editTextNumber1, editTextNumber2)

            if (numbers != null) {
                val result = numbers.first + numbers.second
                textViewResult.text = "결과: $result"
            } else {
                textViewResult.text = "숫자를 입력하세요."
            }
        }

        // 뺄셈
        buttonSubtract.setOnClickListener {
            val numbers = getNumbers(editTextNumber1, editTextNumber2)

            if (numbers != null) {
                val result = numbers.first - numbers.second
                textViewResult.text = "결과: $result"
            } else {
                textViewResult.text = "숫자를 입력하세요."
            }
        }

        // 곱셈
        buttonMultiply.setOnClickListener {
            val numbers = getNumbers(editTextNumber1, editTextNumber2)

            if (numbers != null) {
                val result = numbers.first * numbers.second
                textViewResult.text = "결과: $result"
            } else {
                textViewResult.text = "숫자를 입력하세요."
            }
        }

        // 나눗셈
        buttonDivide.setOnClickListener {
            val numbers = getNumbers(editTextNumber1, editTextNumber2)

            if (numbers != null) {
                if (numbers.second == 0.0) {
                    textViewResult.text = "0으로 나눌 수 없습니다."
                } else {
                    val result = numbers.first / numbers.second
                    textViewResult.text = "결과: $result"
                }
            } else {
                textViewResult.text = "숫자를 입력하세요."
            }
        }
    }

    private fun getNumbers(
        number1: EditText,
        number2: EditText
    ): Pair<Double, Double>? {

        val first = number1.text.toString().toDoubleOrNull()
        val second = number2.text.toString().toDoubleOrNull()

        return if (first != null && second != null) {
            Pair(first, second)
        } else {
            null
        }
    }
}