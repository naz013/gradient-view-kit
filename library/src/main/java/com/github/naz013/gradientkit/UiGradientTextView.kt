package com.github.naz013.gradientkit

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView

class UiGradientTextView : AppCompatTextView {

  private val textHelper = UiGradientTextHelper(this)

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  fun clearSections() {
    textHelper.clear()
    text = text.toString()
  }

  fun addStrikeThroughSection(startIndex: Int, endIndex: Int) {
    textHelper.addStrikeThroughSection(startIndex, endIndex)
  }

  fun addStrikeThroughSection(
    strikeThroughText: String,
    allOccurrences: Boolean = false
  ) {
    val textString = text.toString()
    if (allOccurrences) {
      findAllOccurrences(
        where = textString,
        query = strikeThroughText,
        startIndex = 0
      ) { start, end ->
        addStrikeThroughSection(start, end)
      }
    } else {
      val startIndex = textString.indexOf(strikeThroughText)
      if (startIndex != -1) {
        addStrikeThroughSection(startIndex, startIndex + strikeThroughText.length)
      }
    }
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
    @ColorInt endColor: Int,
    allOccurrences: Boolean = false
  ) {
    val textString = text.toString()
    if (allOccurrences) {
      findAllOccurrences(
        where = textString,
        query = gradientText,
        startIndex = 0
      ) { start, end ->
        addGradientSection(start, end, startColor, endColor)
      }
    } else {
      val startIndex = textString.indexOf(gradientText)
      if (startIndex != -1) {
        addGradientSection(startIndex, startIndex + gradientText.length, startColor, endColor)
      }
    }
  }

  fun addGradientSection(
    gradientText: String,
    startColorHex: String,
    endColorHex: String,
    allOccurrences: Boolean = false
  ) {
    try {
      val startColor = Color.parseColor(startColorHex)
      val endColor = Color.parseColor(endColorHex)
      addGradientSection(gradientText, startColor, endColor, allOccurrences)
    } catch (e: Exception) {
      throw UiWrongColorException
    }
  }

  fun addBoldSection(startIndex: Int, endIndex: Int) {
    textHelper.addBoldSection(startIndex, endIndex)
  }

  fun addBoldSection(boldText: String, allOccurrences: Boolean = false) {
    val textString = text.toString()
    if (allOccurrences) {
      findAllOccurrences(
        where = textString,
        query = boldText,
        startIndex = 0
      ) { start, end ->
        addBoldSection(start, end)
      }
    } else {
      val startIndex = textString.indexOf(boldText)
      if (startIndex != -1) {
        addBoldSection(startIndex, startIndex + boldText.length)
      }
    }
  }

  fun addItalicSection(startIndex: Int, endIndex: Int) {
    textHelper.addItalicSection(startIndex, endIndex)
  }

  fun addItalicSection(italicText: String, allOccurrences: Boolean = false) {
    val textString = text.toString()
    if (allOccurrences) {
      findAllOccurrences(
        where = textString,
        query = italicText,
        startIndex = 0
      ) { start, end ->
        addItalicSection(start, end)
      }
    } else {
      val startIndex = textString.indexOf(italicText)
      if (startIndex != -1) {
        addItalicSection(startIndex, startIndex + italicText.length)
      }
    }
  }

  private fun findAllOccurrences(
    where: String,
    query: String,
    startIndex: Int = 0,
    callback: (start: Int, end: Int) -> Unit
  ) {
    val length = query.length

    var startInternal = -1
    var end = false

    while (!end) {
      startInternal = if (startInternal == -1) {
        where.indexOf(query, startIndex)
      } else {
        where.indexOf(query, startIndex = startInternal)
      }
      if (startInternal == -1) {
        end = true
      } else {
        callback.invoke(startInternal, startInternal + length)
        startInternal += length
      }
    }
  }
}
