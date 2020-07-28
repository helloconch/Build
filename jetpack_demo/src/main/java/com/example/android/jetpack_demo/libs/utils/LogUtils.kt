package com.example.android.jetpack_demo.libs.utils

import android.util.Log

class LogUtils {
    companion object {
        fun print(tag: String = "LOG", message: String) {
            Log.i(tag, message)
        }
    }

}