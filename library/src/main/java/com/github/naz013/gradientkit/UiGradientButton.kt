package com.github.naz013.gradientkit

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatButton

class UiGradientButton : AppCompatButton {

  private val textHelper = UiGradientTextHelper(this)

  constructor(context: Context) : super(context) {
    init(context, null)
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init(context, attrs)
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    init(context, attrs)
  }

  fun addGradientSection(
    startIndex: Int,
    endIndex: Int,
    @ColorInt startColor: Int,
    @ColorInt endColor: Int
  ) {
    textHelper.addGradientSection(startIndex, endIndex, startColor, endColor)
  }

  fun addGradientSection(
    startIndex: Int,
    endIndex: Int,
    startColorHex: String,
    endColorHex: String
  ) {
    try {
      val startColor = Color.parseColor(startColorHex)
      val endColor = Color.parseColor(endColorHex)
      addGradientSection(startIndex, endIndex, startColor, endColor)
    } catch (e: Exception) {
      throw UiWrongColorException
    }
  }

  fun addGradientSection(
    gradientText: String,
    @ColorInt startColor: Int,
    @ColorInt endColor: Int
  ) {
    val textString = text.toString()
    val startIndex = textString.indexOf(gradientText)
    if (startIndex != -1) {
      addGradientSection(startIndex, startIndex + gradientText.length, startColor, endColor)
    }
  }

  fun addGradientSection(
    gradientText: String,
    startColorHex: String,
    endColorHex: String
  ) {
    try {
      val startColor = Color.parseColor(startColorHex)
      val endColor = Color.parseColor(endColorHex)
      addGradientSection(gradientText, startColor, endColor)
    } catch (e: Exception) {
      throw UiWrongColorException
    }
  }

  fun clearGradient() {
    textHelper.clear()
    text = text.toString()
  }

  private fun init(context: Context, attrs: AttributeSet?) {
    if (attrs != null) {
      val a = context.theme.obtainStyledAttributes(attrs, R.styleable.UiGradientButton, 0, 0)
      try {
        val animate =
          a.getBoolean(R.styleable.UiGradientButton_gradientButton_animate, false)
        val orientation =
          a.getInt(R.styleable.UiGradientButton_gradientButton_orientation, 6)

        val animEnter = a.getInt(
          R.styleable.UiGradientButton_gradientButton_animationEnterDuration,
          10
        )
        val animExit = a.getInt(
          R.styleable.UiGradientButton_gradientButton_animationExitDuration,
          5000
        )

        val startColor =
          a.getColor(R.styleable.UiGradientButton_gradientButton_startColor, -1)
        val centerColor =
          a.getColor(R.styleable.UiGradientButton_gradientButton_centerColor, -1)
        val endColor =
          a.getColor(R.styleable.UiGradientButton_gradientButton_endColor, -1)

        val colorsId =
          a.getResourceId(R.styleable.UiGradientButton_gradientButton_colors, -1)

        val cornerRadius =
          a.getDimension(R.styleable.UiGradientButton_gradientButton_cornerRadius, 0f)

        val colors = if (startColor != -1 && endColor != -1) {
          if (centerColor == -1) {
            intArrayOf(startColor, endColor)
          } else {
            intArrayOf(startColor, centerColor, endColor)
          }
        } else if (colorsId != -1) {
          resources.getIntArray(colorsId).takeIf { it.isNotEmpty() }
        } else {
          null
        }
        if (colors != null) {
          val gradientHelper = UiGradientBackgroundHelper(
            colors,
            cornerRadius,
            orientation,
            animate,
            animEnter,
            animExit
          )
          gradientHelper.applyBackground { background = it }
        }
      } finally {
        a.recycle()
      }
    }
  }
}
