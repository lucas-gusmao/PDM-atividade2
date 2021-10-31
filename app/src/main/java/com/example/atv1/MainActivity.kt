package com.example.atv1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var redBar: SeekBar
    private lateinit var greenBar: SeekBar
    private lateinit var blueBar: SeekBar
    private lateinit var colors: LinearLayout
    private lateinit var tvColor: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.colors = findViewById(R.id.colors)
        this.tvColor = findViewById(R.id.tvColor)

        this.redBar = findViewById(R.id.skred)
        this.redBar.setOnSeekBarChangeListener(OnChange())

        this.blueBar = findViewById(R.id.skblue)
        this.blueBar.setOnSeekBarChangeListener(OnChange())

        this.greenBar = findViewById(R.id.skgreen)
        this.greenBar.setOnSeekBarChangeListener(OnChange())
    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            backgroundColorUpdate()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

    fun backgroundColorUpdate(){
        var red = this.redBar.progress
        var green = this.greenBar.progress
        var blue = this.blueBar.progress
        var color = Color.rgb(red, green, blue)
        this.colors.setBackgroundColor(color)
        this.tvColor.text = (red.toString() + green.toString() + blue.toString())

    }
}