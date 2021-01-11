package com.android.jetpack;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public interface IViewLifecycle {
    AppLifecycleObserver appLifecycleObservable = new LiveLifecycleObservable();

    /**
     * 提供给View的AppLifecycleObserver
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    default AppLifecycleObserver lifecycleObserver() {
        appLifecycleObservable.register(this);
        return appLifecycleObservable;
    }

    /**
     * 监听Activity/fragment生命周期
     *
     * @param lifecycleOwner
     * @param lifecycleEvent
     */
    void onLifecycleChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event lifecycleEvent);

}
