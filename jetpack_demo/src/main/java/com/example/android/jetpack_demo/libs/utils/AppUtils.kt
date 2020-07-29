package com.example.android.jetpack_demo.libs.utils

import android.content.Context
import com.example.android.jetpack_demo.ExtApplication

object AppUtils {

    val context: Context
        get() = ExtApplication.context!!
}