package com.reo.running.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.reo.running.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counterA = 0
        val viewModel: CountViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            counterA++
            text1.setText(counterA.toString())

            viewModel.counterB.value = viewModel.counterB.value!! + 1
        }

        val countObserver = Observer<Int> { counter ->
            text2.text = counter.toString()
        }

        viewModel.counterB.observe(this,countObserver)
    }
}