package com.android.building.test

enum class EnumColor {
    RED, ORANGE, BLUE, YELLOW
}

fun getColorName(color: EnumColor) = when (color) {
    EnumColor.RED -> "红"
    EnumColor.ORANGE -> "橙"
    EnumColor.BLUE -> "蓝"
    else -> "OTHER"
}


fun getWarmth(color: EnumColor) =
    when (color) {
        EnumColor.RED, EnumColor.ORANGE -> "暖色"
        else -> "冷色系"
    }


fun mix(c1: EnumColor, c2: EnumColor) =
    when (setOf(c1, c2)) {
        setOf(EnumColor.RED, EnumColor.YELLOW) -> EnumColor.ORANGE
        else -> ""
    }


fun main() {
    println(getColorName(EnumColor.ORANGE))
    println(getColorName(EnumColor.BLUE))
    println(getColorName(EnumColor.YELLOW))

    println(getWarmth(EnumColor.ORANGE))
}