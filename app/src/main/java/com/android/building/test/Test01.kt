package com.android.building.test

data class Animal(val name: String, val age: Int? = null)


class A {

    val name: String = "hello"

    inner class B {
        val a = A()

        val b = name
    }


    class C {

    }
}


fun main() {

    val c = A.C()

    println("-------")

    val animals = listOf<Animal>(Animal("Dog"), Animal("Monkey", 10))

    //左边表达式非空则返回左边的表达式数据 否则返回右边
    val oldest = animals.maxBy { it.age ?: 0 }

    println("oldest anim :${oldest}")


    var p = P("xiaoming", true)

    p.isMarried = false

    println("p name:${p.name}")
    println("p married:${p.isMarried}")

}