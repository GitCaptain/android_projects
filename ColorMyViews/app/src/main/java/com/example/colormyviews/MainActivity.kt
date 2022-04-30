package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> = listOf(
                boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText,
                redButton, greenButton, yellowButton
            )
            clickableViews.forEach {
                it.setOnClickListener {
                    makeColored(it)
                }
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}