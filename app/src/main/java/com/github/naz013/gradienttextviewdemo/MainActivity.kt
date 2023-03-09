package com.github.naz013.gradienttextviewdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.naz013.gradientkit.UiGradientTextView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val tv = findViewById<UiGradientTextView>(R.id.demoText)
    tv.text = "Hello gradient world \nAlso strike through"
    tv.addGradientSection(
      "radien",
      Color.parseColor("#009FFF"),
      Color.parseColor("#ec2F4B")
    )
    tv.addGradientSection(
      "world",
      Color.parseColor("#f953c6"),
      Color.parseColor("#b91d73")
    )
    tv.addBoldSection("adient")
    tv.addBoldSection("Also")
    tv.addStrikeThroughSection("strike through")
    tv.addGradientSection(
      "strike",
      Color.parseColor("#FFFFFF"),
      Color.parseColor("#333333")
    )
  }
}
