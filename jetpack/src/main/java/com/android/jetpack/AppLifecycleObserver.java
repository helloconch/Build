package com.android.jetpack;


import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.ArrayList;

public interface AppLifecycleObserver extends LifecycleObserver {
    ArrayList<IViewLifecycle> viewLifecycles = new ArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(
            @NonNull LifecycleOwner lifecycleOwner,
            @NonNull Lifecycle.Event lifecycleEvent);

    void register(IViewLifecycle viewLifecycleChanged);

    void unRegister(IViewLifecycle viewLifecycleChanged);

}
