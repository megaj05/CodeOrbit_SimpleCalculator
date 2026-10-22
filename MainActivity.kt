
package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)

        val add = findViewById<Button>(R.id.add)
        val subtract = findViewById<Button>(R.id.subtract)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)
        val clear = findViewById<Button>(R.id.clear)

        fun calculate(operation: String) {
            val a = num1.text.toString().toDoubleOrNull()
            val b = num2.text.toString().toDoubleOrNull()

            if (a == null || b == null) {
                Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show()
                return
            }

            val answer = when (operation) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> {
                    if (b == 0.0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    a / b
                }
                else -> 0.0
            }

            result.text = "Result: $answer"
        }

        add.setOnClickListener { calculate("+") }
        subtract.setOnClickListener { calculate("-") }
        multiply.setOnClickListener { calculate("*") }
        divide.setOnClickListener { calculate("/") }

        clear.setOnClickListener {
            num1.text.clear()
            num2.text.clear()
            result.text = "Result:"
        }
    }
}
