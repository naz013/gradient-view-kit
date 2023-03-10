package com.github.naz013.gradienttextviewdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.naz013.gradientkit.UiGradientButton
import com.github.naz013.gradientkit.UiGradientCheckBox
import com.github.naz013.gradientkit.UiGradientTextView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val tv = findViewById<UiGradientTextView>(R.id.demoText)
    tv.text = "Hello gradient world \nAlso strike through\nAnd Italic one"
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
    tv.addItalicSection("Italic")
    tv.addBoldSection("Italic")
    tv.addGradientSection(
      "Italic",
      Color.parseColor("#009FFF"),
      Color.parseColor("#ec2F4B")
    )
    tv.addGradientSection(
      "strike",
      Color.parseColor("#FFFFFF"),
      Color.parseColor("#333333")
    )

    val llTv = findViewById<UiGradientTextView>(R.id.llText)
    llTv.text = "Gradient LinearLayout with animated background"
    llTv.addGradientSection(
      "LinearLayout",
      Color.parseColor("#0F2027"),
      Color.parseColor("#203A43")
    )

    val llTv2 = findViewById<UiGradientTextView>(R.id.ll2Text)
    llTv2.text = "Gradient LinearLayout no animation"
    llTv2.addGradientSection(
      "LinearLayout",
      Color.parseColor("#ee9ca7"),
      Color.parseColor("#ffdde1")
    )

    val frameTv = findViewById<UiGradientTextView>(R.id.frameText)
    frameTv.text = "Gradient FrameLayout with animated background"
    frameTv.addGradientSection(
      "FrameLayout",
      Color.parseColor("#0F2027"),
      Color.parseColor("#203A43")
    )

    val rlTv = findViewById<UiGradientTextView>(R.id.rlText)
    rlTv.text = "Gradient RelativeLayout with animated background"
    rlTv.addGradientSection(
      "RelativeLayout",
      Color.parseColor("#0F2027"),
      Color.parseColor("#203A43")
    )

    val cardTv = findViewById<UiGradientTextView>(R.id.cardText)
    cardTv.text = "Gradient CardView"
    cardTv.addGradientSection(
      "CardView",
      Color.parseColor("#0f0c29"),
      Color.parseColor("#302b63")
    )

    val ipsumTv = findViewById<UiGradientTextView>(R.id.ipsumText)
    ipsumTv.text = IPSUM
    ipsumTv.addGradientSection(
      gradientText = "lacinia",
      startColor = Color.parseColor("#009FFF"),
      endColor = Color.parseColor("#ec2F4B"),
      allOccurrences = true
    )

    val gradientButton = findViewById<UiGradientButton>(R.id.gradientButton)
    gradientButton.addGradientSection(
      gradientText = "Gradient",
      startColor = Color.parseColor("#0F2027"),
      endColor = Color.parseColor("#203A43")
    )

    val gradientCheckbox = findViewById<UiGradientCheckBox>(R.id.gradientCheckbox)
    gradientCheckbox.addGradientToFullText(
      Color.parseColor("#009FFF"),
      Color.parseColor("#ec2F4B")
    )
  }

  companion object {
    private const val IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pulvinar tristique leo ut ultrices. Fusce id consequat nulla. Vivamus vitae justo vel turpis condimentum feugiat. Suspendisse facilisis diam ac eros auctor ultricies. Fusce vel cursus dui. Ut dapibus diam non quam condimentum, at vulputate dolor pretium. Donec volutpat in massa eu finibus.\n" +
      "\n" +
      "Vivamus leo mi, hendrerit a varius at, ultricies ut augue. Aenean pharetra, leo venenatis faucibus lacinia, felis risus lacinia ex, a mollis nulla quam sed magna. Donec sodales enim vel gravida rhoncus. Duis ut nibh id tortor varius pharetra quis sit amet velit. Aenean consequat tempus mi sed sollicitudin. Proin rhoncus suscipit dictum. Cras ultricies dignissim massa, quis tincidunt dui mattis non.\n" +
      "\n" +
      "Quisque eu neque odio. Proin elementum nisl ut nunc lacinia, eget commodo lorem pellentesque. Vivamus faucibus vulputate viverra. Phasellus lacinia dictum eros. Fusce quis tristique odio. Praesent vitae orci pellentesque tortor rutrum volutpat. Aliquam augue diam, bibendum non orci nec, dignissim finibus diam. Aliquam vulputate leo nunc, in sollicitudin metus bibendum ut. In lobortis felis ipsum, id cursus augue faucibus at.\n" +
      "\n" +
      "Curabitur a odio id mauris dignissim mollis. Nullam malesuada, quam eu cursus lacinia, tortor sem molestie felis, eget congue neque tellus et sapien. Sed bibendum dui eget malesuada auctor. Sed eu porttitor sapien. Fusce in nisi feugiat, faucibus tortor eget, vulputate erat. Vivamus dapibus accumsan accumsan. Vivamus commodo neque id tincidunt lacinia. Pellentesque finibus dolor a neque volutpat aliquet. Cras libero mi, sagittis nec felis eget, semper varius enim. Proin venenatis vulputate dignissim."
  }
}
