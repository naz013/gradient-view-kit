package com.github.naz013.gradientkit

import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.UpdateAppearance
import android.widget.TextView
import androidx.annotation.ColorInt

internal class UiGradientTextHelper(
  private val textView: TextView
) {

  private val sections = mutableListOf<Section>()

  fun addGradientSection(
    startIndex: Int,
    endIndex: Int,
    @ColorInt startColor: Int,
    @ColorInt endColor: Int
  ) {
    val textString = getText()
    val length = textString.length
    if (startIndex < 0 || startIndex >= length) {
      throw UiGradientException("Start index is out of bounds")
    }
    if (endIndex <= startIndex || endIndex > length) {
      throw UiGradientException("End index is out of bounds")
    }
    val value = textString.substring(startIndex, endIndex)
    sections.add(GradientSection(value, startColor, endColor, startIndex, endIndex))
    textView.text = create()
  }

  fun addStrikeThroughSection(startIndex: Int, endIndex: Int) {
    val length = getText().length
    if (startIndex < 0 || startIndex >= length) {
      throw UiGradientException("Start index is out of bounds")
    }
    if (endIndex <= startIndex || endIndex > length) {
      throw UiGradientException("End index is out of bounds")
    }
    sections.add(StrikeThroughSection(startIndex, endIndex))
    textView.text = create()
  }

  fun addBoldSection(startIndex: Int, endIndex: Int) {
    val length = getText().length
    if (startIndex < 0 || startIndex >= length) {
      throw UiGradientException("Start index is out of bounds")
    }
    if (endIndex <= startIndex || endIndex > length) {
      throw UiGradientException("End index is out of bounds")
    }
    sections.add(BoldSection(startIndex, endIndex))
    textView.text = create()
  }

  fun addItalicSection(startIndex: Int, endIndex: Int) {
    val length = getText().length
    if (startIndex < 0 || startIndex >= length) {
      throw UiGradientException("Start index is out of bounds")
    }
    if (endIndex <= startIndex || endIndex > length) {
      throw UiGradientException("End index is out of bounds")
    }
    sections.add(ItalicSection(startIndex, endIndex))
    textView.text = create()
  }

  private fun create(): SpannableString {
    if (sections.isEmpty()) {
      return SpannableString(getText())
    }
    val spannableString = SpannableString(getText())
    sections.forEach { section ->
      when (section) {
        is StrikeThroughSection -> {
          spannableString.setSpan(
            StrikethroughSpan(),
            section.startIndex,
            section.endIndex,
            Spannable.SPAN_COMPOSING
          )
        }

        is BoldSection -> {
          spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            section.startIndex,
            section.endIndex,
            Spannable.SPAN_COMPOSING
          )
        }

        is ItalicSection -> {
          spannableString.setSpan(
            StyleSpan(Typeface.ITALIC),
            section.startIndex,
            section.endIndex,
            Spannable.SPAN_COMPOSING
          )
        }

        is GradientSection -> {
          spannableString.setSpan(
            GradientSpan(
              getText(),
              section.startIndex,
              section.endIndex,
              section.startColor,
              section.endColor
            ),
            section.startIndex,
            section.endIndex,
            Spannable.SPAN_COMPOSING
          )
        }
      }
    }
    return spannableString
  }

  fun clear() {
    sections.clear()
  }

  private fun getText(): String {
    return textView.text.toString()
  }

  sealed class Section {
    abstract val value: String
    abstract val startIndex: Int
    abstract val endIndex: Int
  }

  data class StrikeThroughSection(
    override val startIndex: Int,
    override val endIndex: Int
  ) : Section() {
    override val value: String = ""
  }

  data class BoldSection(
    override val startIndex: Int,
    override val endIndex: Int
  ) : Section() {
    override val value: String = ""
  }

  data class ItalicSection(
    override val startIndex: Int,
    override val endIndex: Int
  ) : Section() {
    override val value: String = ""
  }

  data class GradientSection(
    override val value: String,
    val startColor: Int,
    val endColor: Int,
    override val startIndex: Int,
    override val endIndex: Int
  ) : Section()

  private class GradientSpan(
    private val text: String,
    private val startIndex: Int,
    private val endIndex: Int,
    private val colorStart: Int,
    private val colorEnd: Int
  ) : CharacterStyle(), UpdateAppearance {

    override fun updateDrawState(tp: TextPaint?) {
      tp ?: return
      val startX = tp.measureText(text, 0, startIndex)
      val endX = startX + tp.measureText(text, startIndex, endIndex)

      tp.shader = LinearGradient(
        startX,
        0f,
        endX,
        0f,
        colorStart,
        colorEnd,
        Shader.TileMode.MIRROR
      )
    }
  }
}
