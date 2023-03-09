package com.github.naz013.gradientkit

open class UiGradientException(message: String) : Exception(message)

object UiWrongColorException : UiGradientException("Wrong color format")
