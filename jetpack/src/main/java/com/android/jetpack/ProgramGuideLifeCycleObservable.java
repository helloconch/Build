package com.android.jetpack;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class ProgramGuideLifeCycleObservable implements IViewLifecycle {
    private final String TAG = ProgramGuideLifeCycleObservable.class.getSimpleName();
    private long startTimestamp = -1;

    @Override
    public void onLifecycleChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event lifecycleEvent) {
        Log.e(TAG, String.format("onLifecycleChanged>>>> lifecycleOwner :%s  lifecycleEvent:%s", lifecycleOwner, lifecycleEvent));
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle != null) {
            if (Lifecycle.Event.ON_CREATE == lifecycleEvent) {
                startTimestamp = System.currentTimeMillis();
            } else if (Lifecycle.Event.ON_DESTROY == lifecycleEvent) {
                long diff = System.currentTimeMillis() - startTimestamp;
                Log.e(TAG, String.format("用户在节目指南停留时间:%d", diff));
            }
        }
    }
}
