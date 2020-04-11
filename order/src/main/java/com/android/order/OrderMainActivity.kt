package com.android.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.lang.Exception

class OrderMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity_main)
    }

    fun clickPersonal(view: View) {

        //通过类加载的方式跳转到个人中心
        try {
            val clazz = Class.forName("com.android.personal.PersonalMainActivity")
            val intent = Intent(this, clazz::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            println(e.message)
        }


        //全局Map方式


    }
}
