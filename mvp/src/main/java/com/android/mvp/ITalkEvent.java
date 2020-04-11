package com.android.mvp;

public interface ITalkEvent<T> {
    void show(T content);

    void error(String content);
}
