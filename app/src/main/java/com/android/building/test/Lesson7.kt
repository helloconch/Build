package com.android.building.test

import java.lang.IllegalArgumentException

fun strLen(s: String) = s.length

//该类型要么是String/要么null
fun strLenSafe(s: String?): Int {

    if (s != null) {
        return s.length
    } else {
        return 0
    }
}


fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}


class Employee(val name: String, val manager: Employee?)

fun manager(emp: Employee): String? = emp.manager?.name

class Add(
    val streerAddress: String,
    val zipCode: Int,
    val city: String,
    val country: String
)

class Company(val name: String, val address: Add?)

class PPP(val name: String, val company: Company?)


fun PPP.contryName(): String {
    val contry = this.company?.address?.country

    if (contry != null) {
        return contry
    } else {
        return "Unknow"
    }
}

fun main() {
    println(
        strLenSafe("AA")
    )

    printAllCaps("abc")
    printAllCaps(null)


    val ceo = Employee("Da boss", null)
    val dev = Employee("Dev", ceo)

    println(manager(dev))
    println(manager(ceo))

    val pp = PPP("mike", null)
    println(pp.contryName())


    val address = Add("Eless", 8899, "MMM", "GG")

    val company = Company("JJJ", address)


    val p2 = PPP("DD", company)

    printShippingLabel(p2)

    //printShippingLabel(PPP("BB", null))


    val c1 = Cat("DD", "CCC")
    val c2 = Cat("DD", "CCC")

    println(c1 == c2)
    println(c1.equals(c2))


    ignoreNulls("AAA")
    //ignoreNulls(null)


    val email: String? = "XXXX"

    //sendEmailTo(email)

    if (email != null) {
        sendEmailTo(email)
    }

    //let函数 不为null时才调用
    email?.let { email ->
        sendEmailTo(email)
    }

    email?.let { sendEmailTo(it) }


    vertifyUserInput(null)
    vertifyUserInput("")

    vertifyUserInput2(null)

    vertifyUserInput2("")

    printHashCode(null)

    printHashCode2(null)


    showProgress(146)


    val test = test("AAA")

    println("test>> $test")

    test(null)


    val i = 1

    val l: Long = i.toLong()


    val hh = Company("a", null)

    val aaaa = hh.address ?: fail("no address")

    println(">>>${aaaa.country}")


}

/**
 * Elvis运算符
 */
fun foo(s: String?) {
    //如果s为null返回空的字符串否则返回s
    val t: String = s ?: ""
}


fun printShippingLabel(pp: PPP) {
    val address = pp.company?.address ?: throw IllegalArgumentException("argument is error")
    with(address) {
        println(streerAddress)
        println("$zipCode  $city ,$country")
    }
}

/**
 * 安全类型检查
 *
 * foo as? Type
 * foo 是Type类型 返回foo as Type
 * 否则null
 */

class Cat(val firstName: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {

        val otherCat = other as Cat ?: return false

        //在安全类型转换后，变量otherCat被职能转换为Cat类型
        return otherCat.firstName == firstName && otherCat.lastName == lastName

    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}

/**
 * 非空断言
 * foo!! 不等于返回foo  等于null 抛出异常
 *
 */

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {

}

/**
 * 延迟初始化的属性
 */
class MyService {
    fun preformAction(): String = "foo"

}

class MyTest {
    //声明一个不需要初始化的非空类型的属性
    private lateinit var myservcie: MyService


}

fun vertifyUserInput(intput: String?) {
    if (intput.isNullOrBlank()) {
        println("input field")
    }
}

fun vertifyUserInput2(intput: String?) {
    if (intput.isNullOrEmpty()) {
        println("input field")
    }

}

/**
 * 因为t可能为null 所以必须使用安全调用
 */
fun <T> printHashCode(t: T) {

    println(t?.hashCode())
}

fun printHashCode2(name: String?) {

    name?.let {
        println(">>>>>>>")
    }

    println(name?.length)

    if (name.isNullOrEmpty()) {
        println(">>>>>>>isNullOrEmpty")
    }
}

/**
 * 此类型参数声明非空上界，这样T就不能是可空的
 */
fun <T : Any> printHashCode3(t: T) {
    println(t.hashCode())
}


fun showProgress(process: Int) {
    //使用标准库函数coerceIn将值限定在特定范围内
    val percent = process.coerceIn(0, 100)

    println("precent:$percent")
}


fun test(name: String?): Boolean {

    name?.let {
        println("hello test>>>")
    }

    println("length:${name?.length}")


    return false
}


fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
