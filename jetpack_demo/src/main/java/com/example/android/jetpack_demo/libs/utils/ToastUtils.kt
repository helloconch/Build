package com.example.android.jetpack_demo.libs.utils

import android.content.Context
import android.widget.Toast
import io.reactivex.Observable

object ToastUtils {
    private var mToast: Toast? = null

    /**
     * 显示一个toast提示
     *
     * @param resourceId toast字符串资源id
     */
    fun showToast(resourceId: Int) {
        showToast(ResourcesUtils.getString(resourceId))
    }

    /**
     * 显示一个toast提示
     *
     * @param text     toast字符串
     * @param duration toast显示时间
     */
    @JvmOverloads
    fun showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
        showToast(AppUtils.context, text, duration)
    }

    /**
     * 显示一个toast提示
     *
     * @param context  context 上下文对象
     * @param text     toast字符串
     * @param duration toast显示时间
     */
    fun showToast(context: Context, text: String, duration: Int) {
        /**
         * 保证运行在主线程
         */
        val disposable = Observable.just(0)
            .compose(RxHelper.rxScheduler())
            .subscribe {
                if (mToast == null) {
                    mToast = Toast.makeText(context, text, duration)
                } else {
                    mToast!!.setText(text)
                    mToast!!.duration = duration
                }
                mToast!!.show()
            }
    }
}