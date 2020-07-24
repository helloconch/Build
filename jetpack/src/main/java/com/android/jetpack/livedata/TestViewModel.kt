package com.android.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * LiveData + ViewModel
 */
class TestViewModel : ViewModel() {

    var myCurrent: MutableLiveData<String> = MutableLiveData<String>()
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }


    // 将返回开始示例中的 mCurrent 值的长度
    var liveDataMap: LiveData<Int> =
        Transformations.map<String, Int>(myCurrent) { input: String -> input.length }

    var livaDataSwich: LiveData<String> =
        Transformations.switchMap<String, String>(myCurrent) { input: String? ->
            MutableLiveData<String>().also { it.value = input!!.toLowerCase() }
        }
}