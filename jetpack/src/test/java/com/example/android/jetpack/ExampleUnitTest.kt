package com.example.android.jetpack

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
        var datas: ArrayList<String>? = null
        System.out.println(datas?.size ?: "print 0")

        System.out.println(datas?.size)
        // datas必须不为null
        //System.out.println(datas!!.size)

    }
}
