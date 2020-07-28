package com.example.android.jetpack_demo.libs.utils

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * SharedPreference工具类 委托调用
 */
class PreferenceUtils<T>(val key: String, val defalutValue: T) : ReadWriteProperty<Any?, T> {

    companion object {
        lateinit var preferences: SharedPreferences
        private var preferenceName = "_shared_preference_default"
        fun init(context: Context) {
            val name = context.packageName + preferenceName
            LogUtils.print(message = name)
            preferences =
                context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T = getPreference()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = savePreference(value)

    private fun getPreference(): T {
        return with(preferences) {
            val result: Any = when (defalutValue) {
                is Int -> getInt(key, defalutValue)
                is String -> getString(key, defalutValue)
                is Float -> getFloat(key, defalutValue)
                is Boolean -> getBoolean(key, defalutValue)
                is Long -> getLong(key, defalutValue)
                else -> throw  IllegalArgumentException("This type can be saved into Preferences")
            }
            result as T
        }
    }

    private fun savePreference(value: T) {
        with(preferences.edit()) {
            when (value) {
                is Int -> putInt(key, value)
                is String -> putString(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                else -> throw java.lang.IllegalArgumentException("This type can be saved into Preferences")
            }
        }.apply()
    }
}