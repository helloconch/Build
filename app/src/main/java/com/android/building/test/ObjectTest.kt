package com.android.building.test

import java.io.File

class PersonItem {

}

/**
 * object关键字定义一个类并且同时创建该类的一个示例
 */
object PayRool {
    val allEmployees = arrayListOf<PersonItem>()

    fun calculateSalary() {
        for (p in allEmployees) {

        }
    }
}

object CaseComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class AAA {
    /**
     * 类似java中静态方法
     */
    companion object {
        fun bar() {
            println("AAA.bar")
        }
    }
}


class Word(val firstname: String, val lastname: String) {
    companion object {

    }

    fun print(){

    }
}

/**
 * 给类扩展函数
 * 使用类直接调用类.Companion.method()
 */
fun Word.Companion.fromJson(json: String) {

}

fun main() {

    PayRool.allEmployees.add(PersonItem())


    println(CaseComparator.compare(File("/User"), File("/user")))


    val files = listOf(File("/Z"), File("/a"))

    println(files.sortedWith(CaseComparator))


    val w=Word("a","")
    w.print()



}