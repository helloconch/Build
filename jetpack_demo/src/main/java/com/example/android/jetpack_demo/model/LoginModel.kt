package com.example.android.jetpack_demo.model

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android.jetpack_demo.repository.LoginRepository

class LoginModel(val loginRepository: LoginRepository) : ViewModel() {

    val loginState = Transformations.map(loginRepository.loginLiveData) { it }!!

    val registerState = Transformations.map(loginRepository.registerLiveData) { it }!!


    fun login(account: String, pswd: String) {
        loginRepository.login(account, pswd)
    }

    fun register(account: String, pswd: String, rpswd: String) {
        loginRepository.register(account, pswd, rpswd)
    }

}