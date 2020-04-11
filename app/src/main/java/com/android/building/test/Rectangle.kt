package com.android.building.test

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}


fun main(){
    val rectangle=Rectangle(23,22)

    println(rectangle.isSquare)
}