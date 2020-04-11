package com.android.building.test

interface Clickable {
    fun click()

    fun showOff() {
        println("I am showoff")
    }
}


class Button : Clickable {
    override fun click() {
        println("clicked")
    }
}


open class RichButton : Clickable {
    //这个方法是final 不能被子类重写
    fun disable() {}

    //override 成为open类型  增加final可防止被继承
    override fun click() {

    }
}

class ChildRichButton : RichButton() {


}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

fun main() {

}