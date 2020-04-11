package com.android.building.test

import android.content.Context
import android.widget.TextView
import java.io.File


import kotlin.text.StringBuilder

data class Farmer(val name: String, val age: Int)
data class Book(val title: String, val authors: List<String>)

fun findOldestFarmer(farmers: List<Farmer>) {

    println(farmers.maxBy { it.age })

    println(farmers.maxBy(Farmer::age))

    println(farmers.maxBy { f: Farmer -> f.age })


}

//顶层函数
fun salute() = println("salute")


fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }
        .any { it.isHidden }


fun main() {


    val farmers = listOf<Farmer>(
        Farmer("a1", 18),
        Farmer("a2", 6), Farmer("a3", 19), Farmer("a6", 22)
    )

    findOldestFarmer(farmers)


    val sum = { x: Int, y: Int -> x + y }

    println(sum(1, 2))

    val names = farmers.joinToString(separator = " ", transform = { f: Farmer -> f.name })

    println(names)


    var sum2 = { x: Int, y: Int ->
        println("正在计算$x and $y 的和")
        x + y
    }

    println(sum2(3, 6))


    val messages = listOf<String>("403", "404")
    printMessage(messages, "error:")

    printProblemCounts(messages)


    //成员引用
    val getAge = Farmer::age
    //等同于
    val getAge1 = { farmer: Farmer -> farmer.age }

    println(farmers.maxBy(getAge).toString())
    println(farmers.maxBy(getAge1))

    println(salute())
    println(::salute)


    val list = listOf(1, 2, 3, 4, 5, 6)
    println(list.filter { it % 2 == 0 })

    println(list.filter { it > 3 })

    println(list.map { it + 2 })

    println(list.filter { it % 2 == 0 }.map { it * 2 })


    val numbers = mapOf(0 to "zero", 1 to "one")

    println(numbers.mapValues { it.value.toUpperCase() })


    val canBeInClub27 = { p: Farmer -> p.age <= 27 }

    val ff = listOf<Farmer>(
        Farmer("JA", 18),
        Farmer("f", 27),
        Farmer("e", 25),
        Farmer("t", 28)
    )

    //是否集合中所有满足条件
    println(ff.all(canBeInClub27))
    //是否集合至少存在一个元素满足该条件
    println(ff.any(canBeInClub27))

    //获取符合条件的第一个
    println(ff.find(canBeInClub27))

    //按照age分组
    println(ff.groupBy(Farmer::age))


    println(list)
    println(list.any { it != 3 })

    val ll = listOf<String>("a", "ab", "b")
    println(ll.groupBy(String::first))


    val books = listOf(
        Book("Book12", listOf("author1", "author2")),
        Book("Book23", listOf("author2", "author3")),
        Book("Book56", listOf("author5", "author6"))
    )


    println(books.flatMap { it.authors }.toSet())

    //等价于后面这两步
    println(books.map { it.authors })
    println(books.map { it.authors }.flatten())


    val strings = listOf("abc", "def")

    println(strings.flatMap { it.toList() })

    println(strings.map { it.toList() })
    println(strings.map { it.toList() }.flatten())




    println(farmers.map(Farmer::name).filter { it.startsWith("a") })

    //提高性能 转化为序列
    println(farmers.asSequence().map(Farmer::name).filter { it.startsWith("a") }.toList())


    //末端操作
    listOf(1, 2, 3, 4, 5, 6, 7).asSequence()
        .map { print("map($it) ");it * it }
        .filter { print("filter($it) ");it % 2 == 0 }.toList()


    //创建序列
    val nature = generateSequence(0) { it + 1 }
    val nature100 = nature.takeWhile { it <= 100 }
    println()
    println(nature100.sum())


    val file = File("/Users/xx.a.txt")
    println(file.isInsideHiddenDirectory())


    println(alphabet())
    println(alphabetWith())

}

fun printMessage(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix  $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else {
            serverErrors++
        }
    }

    println("客户端错误个数:$clientErrors   服务端错误个数:$serverErrors")
}


fun alphabet(): String {
    val result = StringBuilder()
    for (leffer in 'A'..'Z') {
        result.append(leffer)
    }
    result.append("\n Now I know the  alphabet")

    return result.toString()
}

fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (leffer in 'A'..'Z') {
            this.append(leffer)
        }
        this.append("\n Now I know the  alphabet")

        this.toString()
    }
}

fun alphabetApply() = StringBuilder().apply() {
    for (leffer in 'A'..'Z') {
        this.append(leffer)
    }
    this.append("\n Now I know the  alphabet")

}.toString()

fun alphabetApply3() = buildString {
    for (leffer in 'A'..'Z') {
        this.append(leffer)
    }
    this.append("\n Now I know the  alphabet")

}


fun createViewWithCustomAttributes(ctx: Context) {
    TextView(ctx).apply {
        text = "sample Text"
        textSize = 20.0f
        setPadding(10, 0, 0, 0)
    }
}