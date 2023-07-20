package com.example.calculator_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    private lateinit var outputEditText: EditText

    private var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditText = findViewById<EditText>(R.id.input)
        inputEditText.movementMethod = ScrollingMovementMethod()
        inputEditText.isActivated
        inputEditText.isPressed

        outputEditText = findViewById(R.id.output)

        var text: String


        val btn1 = findViewById<Button>(R.id.button_1)
        btn1.setOnClickListener {
            text = inputEditText.text.toString() + "1"
            inputEditText.setText(text)
        }

        val btn2 = findViewById<Button>(R.id.button_2)
        btn2.setOnClickListener {
            text = inputEditText.text.toString() + "2"
            inputEditText.setText(text)
            result(text)
        }

        val btn3 = findViewById<Button>(R.id.button_3)
        btn3.setOnClickListener{
            text = inputEditText.text.toString() + "3"
            inputEditText.setText(text)
            result(text)
        }

        val btn4 = findViewById<Button>(R.id.button_4)
        btn4.setOnClickListener{
            text = inputEditText.text.toString() + "4"
            inputEditText.setText(text)
            result(text)
        }

        val btn5 = findViewById<Button>(R.id.button_5)
        btn5.setOnClickListener{
            text = inputEditText.text.toString() + "5"
            inputEditText.setText(text)
            result(text)
        }

        val btn6 = findViewById<Button>(R.id.button_6)
        btn6.setOnClickListener{
            text = inputEditText.text.toString() + "6"
            inputEditText.setText(text)
            result(text)
        }

        val btn7 = findViewById<Button>(R.id.button_7)
        btn7.setOnClickListener{
            text = inputEditText.text.toString() + "7"
            inputEditText.setText(text)
            result(text)
        }

        val btn8 = findViewById<Button>(R.id.button_8)
        btn8.setOnClickListener{
            text = inputEditText.text.toString() + "8"
            inputEditText.setText(text)
            result(text)
        }

        val btn9 = findViewById<Button>(R.id.button_9)
        btn9.setOnClickListener{
            text = inputEditText.text.toString() + "9"
            inputEditText.setText(text)
            result(text)
        }

        val btn0 = findViewById<Button>(R.id.buttonSingleZero)
        btn0.setOnClickListener{
            text = inputEditText.text.toString() + "0"
            inputEditText.setText(text)
            result(text)
        }

        val btn00 = findViewById<Button>(R.id.buttonDoubleZero)
        btn00.setOnClickListener{
            text = inputEditText.text.toString() + "00"
            inputEditText.setText(text)
            result(text)
        }

        val btnDot = findViewById<Button>(R.id.buttonDot)
        btnDot.setOnClickListener{
            text = inputEditText.text.toString() + "."
            inputEditText.setText(text)
            result(text)
        }


        //operation perform in operator

        val btnAdd = findViewById<Button>(R.id.buttonAddition)
        btnAdd.setOnClickListener{
            text = inputEditText.text.toString() + "+"
            inputEditText.setText(text)
            check += 1 //check = check + 1
        }

        val btnSub = findViewById<Button>(R.id.buttonSubtraction)
        btnSub.setOnClickListener{
            text = inputEditText.text.toString() + "-"
            inputEditText.setText(text)
            check += 1
        }

        val btnMul = findViewById<Button>(R.id.buttonMultiplication)
        btnMul.setOnClickListener{
            text = inputEditText.text.toString() + "*"
            inputEditText.setText(text)
            check += 1
        }

        val btnDiv = findViewById<Button>(R.id.buttonDivision)
        btnDiv.setOnClickListener{
            text = inputEditText.text.toString() + "/"
            inputEditText.setText(text)
            check += 1
        }

        val btnPer = findViewById<Button>(R.id.buttonPercentage)
        btnPer.setOnClickListener{
            text = inputEditText.text.toString() + "%"
            inputEditText.setText(text)
            check += 1
        }


        // operate equal

        val btnEqual = findViewById<Button>(R.id.button_Equal)
        btnEqual.setOnClickListener{
            text = outputEditText.text.toString()
            inputEditText.setText(text)
            outputEditText.text = null
        }


        //operate clear
        val btnAllClear = findViewById<Button>(R.id.buttonAllClear)
        btnAllClear.setOnClickListener{
            inputEditText.text = null
            outputEditText.text = null
        }


        //operate backspace
        val btnBackspace = findViewById<Button>(R.id.buttonBackspace)
        btnBackspace.setOnClickListener{
            var backspace: String? = null
            if (inputEditText.text.isNotEmpty()) {

                val stringBuilder = StringBuilder(inputEditText.text)
                val find1 = inputEditText.text.toString()
                val find2 = find1.last()

                if (find2 == '+' || find2 == '-' || find2 == '*' || find2 == '/' || find2 == '%') {
                    check -= 1  //check = check - 1
                }

                stringBuilder.deleteCharAt(inputEditText.text.length - 1)
                backspace = stringBuilder.toString()
                inputEditText.setText(backspace)

                result(backspace)
            }
        }


    }


    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            val mainResult = result.toString()
            if (check == 0) {
                outputEditText.text = null
            } else {
                outputEditText.setText(mainResult)
            }
        } catch (e: ScriptException) {
            Log.e("TAG", "Error")
        }
    }

}


