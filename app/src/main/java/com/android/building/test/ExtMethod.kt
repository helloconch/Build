package com.android.building.test

/**
 * 扩展函数
 */
fun String.lastChar(): Char = this.get(this.length - 1)


/**
 * 定义只读的扩展属性
 */

val String.lastWord: Char
    get() = get(length - 1)


var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }


fun main() {
    val name = "hello"

    println("len:${name.lastChar()}")
    println("len:${name.last()}")

    println("Kotlin".lastWord)


    val sb = java.lang.StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println("读取:${sb.lastChar}")


    val array = arrayOf("aaa", "bbb", "CCC")
    //可变参数 vararg
    //*array 解包 展开运算符
    val list = listOf("abc", *array)
    println(list)


    val map = mapOf(1 to "one", 2 to "two")
    //以通常的方式调用to函数
    //1 to ("one")
    //使用中缀标记调用to函数
    //1 to "one"

    //劈分字符串
    println("12.3-6.A+4.5".split("\\.|-|\\+".toRegex()))

    println("12.3-6.A+4.5".split(".", "-", "+"))


    val path: String = "/users/cc/kotlinvideo/function.mp4"

    parsePath(path)

    parseRegex(path)

    val price = """${'$'}99"""
    val price2 = """$99"""
    println(price2)

    saveStu(Stu(1, "", ""))
    Stu(1, "", "").save()
}


fun parsePath(path: String) {
    //目录
    val directory = path.substringBeforeLast("/")

    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")

    val extension = fullName.substringAfterLast(".")

    println("directory:$directory  fullName:$fullName    fileName:$fileName  extension:$extension")
}

fun parseRegex(path: String) {
    //最后一个斜线之前的字串 、最后一个点之前点字串、剩余的部分
    val regex = """(.+)/(.+)\.(.+)""".toRegex()

    val mathResult = regex.matchEntire(path)

    if (mathResult != null) {
        val (direction, filename, extendsion) = mathResult.destructured
        println("directory:$direction     fileName:$filename  extension:$extendsion")
    }
}

class Stu(val id: Int, val name: String, val address: String)

fun saveStu(stu: Stu) {


    fun validate(
        value: String,
        fileName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${fileName} is empty")
        }
    }

    validate(stu.name, "name")
    validate(stu.address, "address")

//    if (stu.name.isEmpty()) {
//        throw IllegalArgumentException("name is empty")
//    }
//    if (stu.address.isEmpty()) {
//        throw IllegalArgumentException("address is empty")
//    }
    //保存到数据库

}

/**
 * 局部函数扩展
 */
fun Stu.save() {

    fun validate(
        value: String,
        fileName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${fileName} is empty")
        }
    }

    validate(name, "name")
    validate(address, "address")


}



