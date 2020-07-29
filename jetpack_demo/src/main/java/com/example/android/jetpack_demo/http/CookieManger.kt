package com.example.android.jetpack_demo.http

import android.content.Context
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieManger(val ctx: Context) : CookieJar {

    companion object {
    }


    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}