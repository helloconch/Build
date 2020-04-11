package com.android.building.test

import android.widget.TextView

//mTextView可能为空
val mTextView: TextView? = null

//一般采用这种方式
lateinit var mTextV: TextView

//var和var区别
//val 可读 get   var 可读可写  set get

// const 可以生成public static final

fun main() {

    //mTextView为空的情况，不调用
    mTextView?.setText("hello")
    //mTextView明显确定不为空时才调用
    //mTextView!!.setText("hello")

    //Kotlin变量必须初始化
    var age: Int = 18
    //println(age)
    //字符串操作
    val price = 23
    var str = "price:${price}"

    println(str)


    var str2 = """
        hello
        world
    """
    println(str2)


    val result = say("BeiJing")
    println(result)


    val result2 = say2("i say...")

    println(result2)


    println("sum:${sum(1, 2)}")


    var backing = BackingProperty("C")

    println(backing.name)
    backing.name = "D"
    println(backing.name)


    var user = User1()
    user.name = "Hello"
    user.age = 1
    user.sex = "none"


    println(user.name)


    var t: String? = null

    println(t?.length)


    var user2 = User2()

    println(user2.age)


    if (user2.isNameInit())
        println(user2.name)


    var user4 = User4("cc", "nan")

    println("name:${user4.name}  sex:${user4.age} age:${user4.age}")


    //数组
    var array = arrayOf(1, 2, 3)

    var destDouble = arrayOf(1.2, 2.5, 3.7)

    var srcDouble = arrayOf(1.2, 2.4, 3.6)

    copy(destDouble, srcDouble)


}


fun say(name: String): String {
    return "hello ${name}"
}

fun say2(name: String) {
    println(name)
}

fun sum(a: Int, b: Int) = a + b


class User {
    val id: Int
    val name: String

    //次构造函数
    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }
}


class Person() {
    var id: Int
    var name: String

    init {
        id = 0
        name = ""
    }

    //主构造函数
    constructor(id: Int, name: String) : this() {
        this.id = id
        this.name = name
    }

}

class School(id: Int) {
    var id: Int
    var name: String


    init {
        this.id = id
        this.name = ""
    }

    constructor(id: Int, name: String) : this(id) {
        this.id = id
        this.name = name
    }
}

class BackingProperty(a: String) {
    private var _name: String = a

    //不保存状态
    var name
        get() = _name
        set(value) {
            this._name = value
        }

}

class User1 {
    lateinit var name: String
    var age: Int = 0
    lateinit var sex: String
}


class User2 {
    lateinit var name: String
    var age: Int = 0

    fun isNameInit(): Boolean {

        //return ::name.isLateini
        return false
    }
}

data class User4(var name: String, var sex: String, var age: Int = 10)


//out取出来【extends 协变】 in存进去【super逆变】


fun copy(dest: Array<Double>, src: Array<Double>) {

}
