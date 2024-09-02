package com.seogaemo.android_length_conversion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.seogaemo.android_length_conversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var inputNumber: Int = 0
    private var cmToM = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditText = binding.inputEditText
        val inputUnitTextView = binding.inputUnitTextView
        val swapButton = binding.swapButton

        inputEditText.addTextChangedListener { text ->
            inputNumber = if (text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }

            if (cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
        }

        swapButton.setOnClickListener {
            cmToM = cmToM.not()
            if (cmToM) {
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }


}