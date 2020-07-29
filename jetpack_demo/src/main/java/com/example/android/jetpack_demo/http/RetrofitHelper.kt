package com.example.android.jetpack_demo.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.conn.ssl.SSLSocketFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private const val TIMEOUT_READ = 20
    private const val TIMEOUT_CONNECTION = 10
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        //SSL证书
        .sslSocketFactory(TrustManager.sslSocketFactory)
        //打印日志
        .hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
        .addInterceptor(interceptor) //设置Cache拦截器
        //.addNetworkInterceptor(cacheInterceptor)
        //.addInterceptor(cacheInterceptor)
        .cache(HttpCache.cache)
        // 设置 Cookie
        //.cookieJar(CookieManger(context))
        //time out
        .connectTimeout(TIMEOUT_CONNECTION.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_READ.toLong(), TimeUnit.SECONDS)
        //失败重连
        .writeTimeout(TIMEOUT_READ.toLong(), TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    fun <T> createApi(clazz: Class<T>?, url: String?): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(clazz)
    }
}