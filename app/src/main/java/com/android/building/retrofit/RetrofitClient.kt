package com.android.building.retrofit

import com.android.building.api.WanAndroidApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {
        const val TAG = "";
        private val INSTANCE = RetrofitClient()
        fun getInstance() = INSTANCE
    }

    private lateinit var retrofit: Retrofit

    private fun createRetrofit(baseUrl: String): Retrofit {
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }


    fun <T> getService(servie: Class<T>, baseUrl: String = WanAndroidApi.URL): T {
        return createRetrofit(baseUrl).create(servie)
    }


}