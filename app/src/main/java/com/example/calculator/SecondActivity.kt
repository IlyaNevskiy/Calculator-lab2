package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val total_count = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       this. showResult()
    }

    private fun showResult() {
        val count = intent.getStringExtra(total_count)

            text_view_res.text = count.toString()

    }
}