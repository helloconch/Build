package com.android.building

import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import com.android.building.api.WanAndroidApi
import com.android.building.retrofit.RetrofitClient
import com.android.building.ui.main.MainFragment
import com.android.building.ui.news.NewsFragment
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "BUILDING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onStart() {
        super.onStart()
        //testRetrofit()




    }


    private fun testRetrofit() {
        // 构建Retrofit对象

        //获取接口代理对象
        var wanAndroidApi =  RetrofitClient.getInstance()
            .getService(WanAndroidApi::class.java)
        //获取具体的请求业务
        val projectCall = wanAndroidApi.getProject()
        //发起同步请求
        //projectCall.execute()

        //发起异步请求
        projectCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i(TAG, "error:${t.message}")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                Log.i(TAG, "success:${response.message()}")
            }

        })

    }

}
