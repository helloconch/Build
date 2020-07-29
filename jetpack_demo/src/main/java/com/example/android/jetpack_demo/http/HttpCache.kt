package com.example.android.jetpack_demo.http

import com.example.android.jetpack_demo.libs.utils.AppUtils
import okhttp3.Cache
import java.io.File

object HttpCache {

    private const val HTTP_RESPONSE_DISK_CACHE_MAX_SIZE: Long = 50 * 1024 * 1024
    val cache: Cache
        get() = Cache(
            File(AppUtils.context.externalCacheDir.absolutePath + File.separator + "data/NetCache"),
            HTTP_RESPONSE_DISK_CACHE_MAX_SIZE
        )


}