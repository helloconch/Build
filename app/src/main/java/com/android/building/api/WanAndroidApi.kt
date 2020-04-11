package com.android.building.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface WanAndroidApi {

    companion object {
        const val URL = "https://www.wanandroid.com/"
    }


    // https://www.wanandroid.com/project/tree/json
    @GET("project/tree/json")
    fun getProject(): Call<ResponseBody>

    @HTTP(method = "get", path = "project/tree/json", hasBody = false)
    fun example(): Call<ResponseBody>

    /**
     * 表示响应体的数据用流的方式返回，适用于返回的数据比较大，
    该注解在在下载大文件的特别有用
     */
    @Streaming
    @GET
    fun download(@Url fileUrl: String): Call<ResponseBody>

    @Headers("Cache-Control:max-age=10000")
    @GET("project/xx")
    fun example1(): Call<ResponseBody>

    @GET("project/xx")
    fun example2(@Header("Authorization") authorization: String): Call<ResponseBody>

    @GET("project/{id}/user")
    fun example3(@Path("id") id: Int): Call<ResponseBody>

    @GET("XXXX")
    fun search(@Query("name") name: String, @QueryMap map: Map<String, String>): Call<ResponseBody>

}