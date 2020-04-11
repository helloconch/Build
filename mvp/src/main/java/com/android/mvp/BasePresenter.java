package com.android.mvp;

import android.content.Context;

import nucleus5.presenter.RxPresenter;

public class BasePresenter<VIEW> extends RxPresenter<VIEW> {
    protected Context context;
}
