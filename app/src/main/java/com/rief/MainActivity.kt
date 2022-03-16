package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.rief.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnCount.setOnClickListener {
               countButton()
            }

            btnReset.setOnClickListener {
                resetButton()
            }
        }
    }

    private fun countButton() {

        val weight = binding.edtBerat.text.toString()
        val height = binding.edtTinggi.text.toString()
        val isGender = binding.radioGroup.checkedRadioButtonId

        when {
            TextUtils.isEmpty(weight) -> {
                binding.edtBerat.requestFocus()
                Toast.makeText(this, "Anda belum menambahkan berat badan!", Toast.LENGTH_SHORT).show()
                return
            }
            TextUtils.isEmpty(height) -> {
                binding.edtTinggi.requestFocus()
                Toast.makeText(this, "Anda belum menambahkan tinggi badan!", Toast.LENGTH_SHORT).show()
                return
            }
            isGender == -1 -> {
                Toast.makeText(this, "Mohon pilih jenis kelamin anda!", Toast.LENGTH_SHORT).show()
                return
            }
            else -> {
                val tall = height.toFloat() / 100
                val count = weight.toFloat() / (tall * tall)

                val gender = isGender == R.id.priaRadioButton
                val des = String.format("%.2f", count)

                val getCat = getBMI(count, gender)

                binding.apply {
                    resultBMI.text = "BMI : $des"
                    resultCategory.text = "Category: $getCat"
                }
            }


        }

    }

    private fun getBMI(count : Float, isGender : Boolean) : String {
        val bmi =
            when(isGender){
                true -> {
                    when {
                        count < 20.5 -> "Kurus"
                        count >= 27.0 -> "Gemuk"
                        else -> "Ideal"
                    }
                }
                false -> {
                    when {
                        count < 18.5 -> "Kurus"
                        count >= 25.0 -> "Gemuk"
                        else -> "Ideal"
                    }
                }
            }
        return bmi
    }

    private fun resetButton(){
        binding.apply {
            edtBerat.text.clear()
            edtTinggi.text.clear()
            radioGroup.clearCheck()
            resultBMI.text = " "
            resultCategory.text = " "
        }
    }
}