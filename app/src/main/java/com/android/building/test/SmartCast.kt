package com.android.building.test

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknow expression")
}

fun main() {

    println(
        eval(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(3)
            )
        )
    )

}