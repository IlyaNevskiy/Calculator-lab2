package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var count = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        null_btn.setOnClickListener{this.setValue("0")}
        one_btn.setOnClickListener{this.setValue("1")}
        two_btn.setOnClickListener{this.setValue("2")}
        three_btn.setOnClickListener{this.setValue("3")}
        four_btn.setOnClickListener{this.setValue("4")}
        five_btn.setOnClickListener{this.setValue("5")}
        six_btn.setOnClickListener{this.setValue("6")}
        seven_btn.setOnClickListener{this.setValue("7")}
        eight_btn.setOnClickListener{this.setValue("8")}
        nine_btn.setOnClickListener{this.setValue("9")}
        minus_btn.setOnClickListener{this.setValue("-")}
        plus_btn.setOnClickListener{this.setValue("+")}
        divide_btn.setOnClickListener{this.setValue("/")}
        mult_btn.setOnClickListener{this.setValue("*")}
        ls_btn.setOnClickListener{this.setValue(")")}
        rs_btn.setOnClickListener{this.setValue("(")}
        dot_btn.setOnClickListener{this.setValue(".")}


        AC_btn.setOnClickListener{
            math_op.text=""
            math_input.text=""
        }

        C_btn.setOnClickListener{
            val str = math_op.text.toString()
            if(str.isNotEmpty()){
                math_op.text = str.substring(0, str.length-1)
                math_input.text=""

            }
        }

        equal_btn.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_op.text.toString()).build()
                val result = ex.evaluate()

                val fractionres = result.toLong()
                if(result==fractionres.toDouble())
                    math_input.text = fractionres.toString()
                else
                    math_input.text = result.toString()

            } catch (e:Exception){
                Log.d("Ошибка", "${e.message}")

            }
        }

    }

    private fun setValue(str: String){
        if( math_input.text != ""){
            math_op.text = math_input.text
            math_input.text = ""
        }

        math_op.append(str)
    }


    fun tratsition(view: View){
        val transIntent = Intent(this, SecondActivity::class.java)
        val countString = math_input.text.toString()

        if (countString!="")
        {
         count = countString
        }
        else {
            count = "Undefined"
        }

        transIntent.putExtra(SecondActivity.total_count, count)
        startActivity(transIntent)
    }
}