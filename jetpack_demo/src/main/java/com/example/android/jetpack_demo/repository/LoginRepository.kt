package com.example.android.jetpack_demo.repository

import androidx.lifecycle.MutableLiveData
import com.example.android.jetpack_demo.bean.LoginBean
import com.example.android.jetpack_demo.http.RetrofitApi
import com.example.android.jetpack_demo.libs.utils.RxHelper
import io.reactivex.functions.Consumer

class LoginRepository {
    val loginLiveData = MutableLiveData<LoginBean>()
    val registerLiveData = MutableLiveData<LoginBean>()

    fun login(username: String, password: String) {

        RetrofitApi.instance.login(username, password)
            .compose(RxHelper.rxScheduler())
            .subscribe(Consumer {
                loginLiveData.value = it
            }, Consumer {
                loginLiveData.value =
                    LoginBean(LoginBean.Data(), errorCode = 500, errorMsg = it.message)
            })

    }

    fun register(account: String, pswd: String, rpswd: String) {

        RetrofitApi.instance.register(account, pswd, rpswd)
            .compose(RxHelper.rxScheduler())
            .subscribe(Consumer {
                registerLiveData.value = it
            }, Consumer {
                registerLiveData.value = LoginBean(LoginBean.Data(), 500, it.message)
            })

    }
}