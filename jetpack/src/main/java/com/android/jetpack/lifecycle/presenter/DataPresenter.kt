package com.android.jetpack.lifecycle.presenter

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class DataPresenter:LifecycleObserver {
    val TAG = DataPresenter::class.java.name

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(@NonNull lifecycleOwner: LifecycleOwner){
        Log.i(TAG, "onStart>>>" + lifecycleOwner.javaClass)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(@NonNull lifecycleOwner: LifecycleOwner){
        Log.i(TAG, "onDestroy>>>" + lifecycleOwner.javaClass)
    }

}