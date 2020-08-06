package com.android.mvp.demo2.action;

public interface Action1<T> extends Action {
    void call(T t);
}
