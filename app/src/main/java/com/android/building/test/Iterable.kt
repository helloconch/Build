@file:JvmName("StringFunctions")

package com.android.building.test

import java.util.*

var name: String = "a";

val name1: String = "b"

const val name2: String = "c"
fun main() {
    var oneToTen = 1..10

    for (i in oneToTen) {
        println(dividedInt(i))
    }


    for (i in 1..10) {

    }

    //降序
    for (i in 10 downTo 1) {

    }

    for (i in 10 downTo 1 step 2) {

    }

    //[1,10)
    for (i in 1 until 11) {

    }


    val treeMap = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        treeMap[c] = binary
    }


    for ((k, v) in treeMap) {
        println("k:$k   v:$v")
    }


    //数组
    val arrayListOf = arrayListOf("123", "333", "55")
    for ((index, element) in arrayListOf.withIndex()) {
        println("index:$index  element:$element")
    }


    println("JavaScript" in "Java".."Kotlin")
    println("JavaScript" in "Java".."pt")


    val set = hashSetOf(1, 2, 3)
    val set2 = setOf(1, 2, 3)
    val arraylist = arrayListOf(1, 2, 3)
    val list = listOf(1, 23, 5, "6")
    val array = arrayOf("1", "2", "3")
    val map = hashMapOf(1 to "one", 7 to "seven")

    //class java.util.HashSet
    println(set.javaClass)
    //class java.util.LinkedHashSet
    println(set2.javaClass)
    //class java.util.ArrayList
    println(arraylist.javaClass)
    //class java.util.Arrays$ArrayList
    println(list.javaClass)
    //class [Ljava.lang.String;
    println(array.javaClass)
    //class java.util.HashMap
    println(map.javaClass)

    val strings = listOf("one", "two", "three")
    println(strings.last())
    println(strings)
    println(joinToString(strings, ";", "(", ")"))
    println(joinToString(strings, separator = ";", prefix = "(", postfix = ")"))


}

fun dividedInt(i: Int) = when {
    i % 3 == 0 -> "$i: 3的倍数"
    i % 4 == 0 -> "$i: 4的倍数"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'


fun isNotDigital(c: Char) = c !in '0'..'9'


fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {

    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)

    }
    result.append(postfix)
    return result.toString()

}

/**
 * java调用kotlin 生成更多重载方法
 */
@JvmOverloads
fun say(name: String, age: Int = 0) {

}

