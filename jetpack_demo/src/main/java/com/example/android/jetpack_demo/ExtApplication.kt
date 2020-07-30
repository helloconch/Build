package com.example.android.jetpack_demo

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Process
import com.example.android.jetpack_demo.libs.utils.LogUtils
import com.example.android.jetpack_demo.libs.utils.PreferenceUtils
import com.example.android.jetpack_demo.libs.aop.login.ILogin
import com.example.android.jetpack_demo.libs.aop.login.LoginAssistant
import com.example.android.jetpack_demo.libs.utils.Constants

class ExtApplication : Application() {

    companion object {

        var context: Context? = null

        var mHandler: Handler? = null

        var mainThreadID = 0

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        mHandler = Handler()
        mainThreadID = Process.myPid()
        PreferenceUtils.init(this)
        LoginAssistant.getInstance().login = loginImpl
    }

    var loginImpl: ILogin = object : ILogin {
        override fun isLogin(): Boolean {
            LogUtils.print(Constants.TAG_LOGIN, "login>>>")
            return false
        }

        override fun login(userDefine: Int) {
            LogUtils.print(Constants.TAG_LOGIN, "login>>>userDefine:$userDefine")
        }

        override fun exitLogin() {
            LogUtils.print(Constants.TAG_LOGIN, "exitLogin>>>")
        }

    }


}