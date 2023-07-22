package com.example.workout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    private var binding : ActivityBmiBinding? = null

    companion object{
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView : String = METRIC_UNITS_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val toolBar = binding?.toolBarBMI
        setSupportActionBar(binding?.toolBarBMI)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            title = "BMI"
            toolBar?.navigationIcon?.setTint(Color.WHITE)
            toolBar?.setTitleTextColor(Color.WHITE)

        }
        binding?.toolBarBMI?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId : Int ->
            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUSUnitsView()
            }
        }


        binding?.btnCalculateUnits?.setOnClickListener {
            calculateUnits()
        }
    }

    private fun makeVisibleMetricUnitsView(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilUSUnitWeight?.visibility = View.GONE
        binding?.tilUSUnitHeightFeet?.visibility = View.GONE
        binding?.tilUSUnitHeightInch?.visibility = View.GONE

        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUSUnitsView() {
        currentVisibleView = US_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilUSUnitWeight?.visibility = View.VISIBLE
        binding?.tilUSUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilUSUnitHeightInch?.visibility = View.VISIBLE

        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun displayBMIResults(bmi : Float){
        val bmiLabel : String
        val bmiDescription : String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = "Extremely Underweight"
            bmiDescription = "Oops! Tou need to take better care of yourself."
        }else if(bmi.compareTo(15f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You need to take better care of yourself."
        }else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Great Job! you are in a good shape."
        }else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You need to take better care of yourself!"
        }else{
            bmiLabel = "Extremely Overweight"
            bmiDescription = "Oops! You need to take better care of yourself!"
        }

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription


    }

    private fun validateMetricUnits() : Boolean{
        var isValid = true
        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun calculateUnits() {
        if (currentVisibleView == METRIC_UNITS_VIEW) {
            if (validateMetricUnits()) {
                val heightValue: Float =
                    binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue * heightValue)
                displayBMIResults(bmi)

            } else {
                Toast.makeText(this@BMIActivity, "Please Enter Valid Values!", Toast.LENGTH_SHORT)
                    .show()
            }
        }else{
            if(validateUSUnits()){
                val usUnitWeightValue : Float =
                    binding?.etUSUnitWeight?.text.toString().toFloat()
                val usUnitHeightValueFeet : String =
                    binding?.etUSUnitHeightFeet?.text.toString()
                val usUnitHeightValueInch : String =
                    binding?.etUSUnitHeightInch?.text.toString()

                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12
                val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))
                displayBMIResults(bmi)
            }else{
                Toast.makeText(this@BMIActivity, "Please Enter Valid Values!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun validateUSUnits() : Boolean {
        var isValid = true

        when {
            binding?.etUSUnitWeight?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etUSUnitHeightFeet?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etUSUnitHeightInch?.text.toString().isEmpty() -> {
                isValid = false
            }
        }

        return isValid
    }


}