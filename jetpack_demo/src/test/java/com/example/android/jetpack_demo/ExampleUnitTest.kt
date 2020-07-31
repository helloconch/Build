package com.example.android.jetpack_demo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        val languageName: String? = null
        println(languageName)
        println(languageName == null)
        if (languageName != null) {
            // No need to write languageName?.toUpperCase()
            println(languageName.toUpperCase())
        }
        println(">>>>")

        //匿名函数
        var contentLen: (String) -> Int = {
            it.length
        }

        var result: Int = contentLen("name")

        var r = stringMapper("android", {
            it.length
        })

        println("r:$r")

        var r2 = stringMapper("android") {
            it.length
        }

        val car = Car()

        println("gallonsOfFuelInTank:${car.gallonsOfFuelInTank}")
        println("car.num:${car.num}")
        car.num = 7
        println("car.num:${car.num}")




    }

    /**
     * 普通函数
     */
    fun contentLen(name: String): Int {
        return 0
    }

    /**
     * 高阶函数
     */
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // Invoke function
        return mapper(str)
    }

    class Car {
        var gallonsOfFuelInTank: Int = 15
            private set

        var num: Int = 0
            get() {
                return field
            }
            set(value) {
                field = value + 2
            }

        var name: String? = null
            get() = field?.toLowerCase()
            set(value) {}
    }
}
