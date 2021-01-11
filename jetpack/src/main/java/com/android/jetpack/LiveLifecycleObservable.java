package com.android.jetpack;


import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class LiveLifecycleObservable implements AppLifecycleObserver {

    @Override
    public void onLifecycleChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event lifecycleEvent) {
        for (IViewLifecycle item : viewLifecycles) {
            item.onLifecycleChanged(lifecycleOwner, lifecycleEvent);
        }
    }

    @Override
    public void register(IViewLifecycle viewLifecycleChanged) {
        viewLifecycles.add(viewLifecycleChanged);
    }

    @Override
    public void unRegister(IViewLifecycle viewLifecycleChanged) {
        viewLifecycles.remove(viewLifecycleChanged);
    }
}
