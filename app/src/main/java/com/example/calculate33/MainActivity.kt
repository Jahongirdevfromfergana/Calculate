package com.example.calculate33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.substring
import androidx.core.content.ContextCompat
import com.example.calculate33.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.io.IOException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDel.setOnClickListener {
            binding.textViewInputNumbers.text = ""
            binding.textViewInputResult.text = ""
        }
        binding.buttonParentLeft.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("(")
        }
        binding.buttonParentRight.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText(")")
        }
        binding.buttonZero.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("0")
        }
        binding.buttonOne.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("1")
        }
        binding.buttonTwo.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("2")
        }
        binding.buttonThree.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("3")
        }
        binding.buttonFour.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("4")
        }
        binding.buttonFive.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("5")
        }
        binding.buttonSix.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("6")
        }
        binding.buttonSeven.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("7")
        }
        binding.buttonEight.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("8")
        }
        binding.buttonNine.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("9")
        }
        binding.buttonDot.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText(".")
        }
        binding.buttonAddition.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("+"  )
        }
        binding.buttonDivision.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("÷")
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("-")
        }
        binding.buttonMultiplication.setOnClickListener {
            binding.textViewInputNumbers.text = addToInputText("x")
        }

        binding.buttonEqual.setOnClickListener {
            shoResult()
        }

        binding.buttonClear.setOnClickListener {
            val texts = binding.textViewInputNumbers
            texts.text.substring(0, texts.length() - 1)
        }
    }
    private fun getInputExpression(): String{
        var expression = binding.textViewInputNumbers.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("x"), "*")
        return expression
    }

    private fun shoResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                binding.textViewInputResult.text = "Error"
                binding.textViewInputResult.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }else{
                binding.textViewInputResult.text = DecimalFormat("0.######").format(result).toString()
                binding.textViewInputResult.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
            }
        }catch (e: IOException){

            binding.textViewInputResult.text = "Error"
            binding.textViewInputResult.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        }
    }
    private fun addToInputText(buttonValue: String): String {
        return "${binding.textViewInputNumbers.text}$buttonValue"

    }
}