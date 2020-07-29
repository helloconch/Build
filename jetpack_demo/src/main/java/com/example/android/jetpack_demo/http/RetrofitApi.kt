package com.example.android.jetpack_demo.http

object RetrofitApi {
    private var api: Api? = null

    val instance: Api
        get() {
            if (api == null) {
                synchronized(RetrofitApi::class.java) {
                    if (api == null) {
                        api = RetrofitHelper.createApi(Api::class.java, url = BASE_URL)
                    }
                }
            }
            return api!!
        }

}