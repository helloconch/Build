package com.android.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.android.jetpack.lifecycle.presenter.DataPresenter

/**
 * 监听自定义类
 */
class MyDataView : LifecycleOwner {

    var lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)
    var dataPresenter: DataPresenter = DataPresenter()
    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }


    fun create() {
        lifecycle.addObserver(dataPresenter)
    }

    fun start() {
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    fun destory() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}