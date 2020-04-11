package com.android.building.test


//class User3 constructor(_nickname: String) {
//    val nickname: String
//
//    init {
//        nickname = _nickname
//    }
//}

//包含一个参数的主要构造器
//class User3 constructor(_nickname: String) {
////    val nickname = _nickname
////
////}


class User3(val nickname: String)


class Context {

}

class AttributeSet {

}

open class View {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: AttributeSet) {

    }
}

class MyButton : View {
    constructor(ctx: Context) : super(ctx) {

    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {

    }
}

class MyButton2 : View {
    constructor(ctx: Context) : this(ctx, AttributeSet()) {

    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {

    }
}


interface IUser {
    /**
     * 定义抽象属性
     */
    val name: String
}

class UserImpl : IUser {
    override val name: String
        get() = "AAA"
}

class User2Impl(override val name: String) : IUser

class User3Impl(val email: String) : IUser {
    override val name: String
        get() = email.substringBefore("@")
}

class FacebookUser(val accountId: Int) : IUser {
    override val name: String =
        getFaceBookName(accountId) //To change initializer of created properties use File | Settings | File Templates.


    fun getFaceBookName(accountId: Int): String {
        return "XXXX";
    }
}

interface IUser2 {
    val email: String

    val nickname: String
        get() {
            if (email != null) {
                return email.substringBefore("@")
            }

            return ""
        }
}

class User5(val name: String) {

    var address: String = "AAA"
        set(value) {
            //读取后备字段的值
            println(""" Address was changed for $name:  "$field" -> "$value" """)
            //修改后备字段的值
            field = value
        }

}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}


class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "name:$name  postalCode:$postalCode"
    }

    /**
     * Any与Java中的java.lang.Object是相似的，它是kotlin中所有类的超类
     */
    override fun equals(other: Any?): Boolean {

        if (other == null || other !is Client) {
            return false
        }

        return name == other.name
                && postalCode == other.postalCode

    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }
}


class Client3(val name: String, val postalCode: Int) {

    //手动添加copy
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) =
        Client3(name, postalCode)
}

fun main() {
    println(User2Impl("1111@kotlin.org").name)
    println(User3Impl("1111@kotlin.org").name)
    println(FacebookUser(22).name)


    val user5 = User5("zhangsan")
    user5.address = "BBB"
    println(user5.address)


    val lengthCounter = LengthCounter()
    lengthCounter.addWord("hi")
    println(lengthCounter.counter)


    val client1 = Client("a", 123)

    println(client1)

    val client2 = Client("a", 123)

    println(client1 == client2)

    println(client1.equals(client2))


    val set = hashSetOf(Client("a", 222))

    println(set.contains(Client("a", 222)))


    var bob = Client3("Bob", 123)
    val bobCopy = bob.copy(postalCode = 11)
    println("bob name: ${bob.name}    postalCode:${bobCopy.postalCode}")
}