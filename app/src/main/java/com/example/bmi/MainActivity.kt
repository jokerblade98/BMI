package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnCalc = findViewById<Button>(R.id.calcButton)
        val btnReset = findViewById<Button>(R.id.resetButton)

        btnCalc.setOnClickListener {
            try {
                val inputWeight = weightInput.text.toString().toDouble()
                val inputHeight = heightInput.text.toString().toDouble()

                val calcBMI: Double = inputWeight / Math.pow(inputHeight, 2.00)

                bmiValue.text = "%.2f".format(calcBMI)


                if (calcBMI < 18.5) {
                    bmiStatus.setImageResource(R.drawable.under)
                    bmiStatusText.text = "Underweight"
                } else if (calcBMI >= 18.5 && calcBMI <= 24.9) {
                    bmiStatus.setImageResource(R.drawable.normal)
                    bmiStatusText.text = "Normal"
                } else if (calcBMI > 24.9){
                    bmiStatus.setImageResource(R.drawable.over)
                    bmiStatusText.text = "Overweight"
                }
                else
                {
                    bmiStatus.setImageResource(R.drawable.empty)
                    bmiStatusText.text = "---"
                }

            }catch (ex: Exception) {
                val toast: Toast = Toast.makeText(this,
                    "Invalid input!", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }

        btnReset.setOnClickListener {
            weightInput.setText("")
            heightInput.setText("")
            bmiValue.setText("---")
            bmiStatusText.setText("---")
            bmiStatus.setImageResource(R.drawable.empty)
        }
    }
}
