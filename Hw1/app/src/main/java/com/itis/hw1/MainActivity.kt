package com.itis.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var ageInput: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nameInput)
        heightInput = findViewById(R.id.heightInput)
        weightInput = findViewById(R.id.weightInput)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val name = nameInput.text.toString()
        val height = heightInput.text.toString().toDoubleOrNull()
        val weight
                = weightInput.text.toString().toDoubleOrNull()
        val age = ageInput.text.toString().toIntOrNull()

        if (validateInputs(name, height, weight, age)) {
            val result = 655.1 + (9.563 * weight!!) + (1.85 * height!!) - (4.676 * age!!)
                resultTextView.text = "Ответ: $result"
        } else {
            resultTextView.text = "Данные введены некорректно."
        }
    }

    private fun validateInputs(name: String? , height: Double?, weight: Double?, age: Int?): Boolean {
        if (name.isNullOrEmpty() || name.length > 50) {
            return false
        }

        if (height == null || height <= 0 || height >= 250) {
            return false
        }

        if (weight == null || weight <= 0 || weight >= 250) {
            return false
        }

        if (age == null || age <= 0 || age >= 150) {
            return false
        }

        return true
    }
}