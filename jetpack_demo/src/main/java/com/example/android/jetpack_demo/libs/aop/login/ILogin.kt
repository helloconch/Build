package com.example.android.jetpack_demo.libs.aop.login

interface ILogin {

    fun isLogin(): Boolean
    /**
     *实现登陆（或跳转到登陆的功能）
     * @param userDefine 表示操作的标志
     */
    fun login(userDefine: Int)

    fun exitLogin()
}