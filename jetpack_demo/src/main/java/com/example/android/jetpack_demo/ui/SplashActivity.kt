package com.example.android.jetpack_demo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.jetpack_demo.libs.utils.Constants
import com.example.android.jetpack_demo.libs.utils.LogUtils
import com.example.android.jetpack_demo.libs.utils.PreferenceUtils
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkData()
    }

    fun checkData() {
        Observable.timer(1, TimeUnit.SECONDS)
            .flatMap {
                LogUtils.print("splashActivity", "name:${Thread.currentThread().name}")
                val isLogin by PreferenceUtils<Boolean>(Constants.login_key, false)
                if (isLogin) {
                    return@flatMap Observable.just(0L)
                } else {
                    return@flatMap Observable.just(1L)
                }
            }.subscribe {
                LogUtils.print("splashActivity", "name:${Thread.currentThread().name}")
                if (it == 0L) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }

                finish()
            }
    }
}