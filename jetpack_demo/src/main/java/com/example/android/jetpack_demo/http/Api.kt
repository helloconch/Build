package com.example.android.jetpack_demo.http

import com.example.android.jetpack_demo.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

const val BASE_URL = "https://www.wanandroid.com"

interface Api {
    @FormUrlEncoded
    @POST("user/login/")
    fun login(@Field("username") username: String, @Field("password") password: String)
            : Observable<LoginBean>

    @FormUrlEncoded
    @POST("user/register/")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<LoginBean>
}