package com.android.jetpack.lifecycle.presenter

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class BasePresenter : IPresenter {

    val TAG = BasePresenter::class.java.name
    override fun onCreate(lifecycleOwner: LifecycleOwner) {

        Log.i(TAG, "onCreate>>>" + lifecycleOwner.javaClass)
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        Log.i(TAG, "onDestory>>>" + lifecycleOwner.javaClass)
    }

    override fun onLifecycleChanged(
        lifecycleOwner: LifecycleOwner,
        lifecycleEvent: Lifecycle.Event
    ) {
        Log.i(TAG, "onLifecycleChanged>>>" + lifecycleEvent.name)
    }


}