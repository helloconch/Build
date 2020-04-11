package com.android.mvp;

import android.os.Bundle;

import nucleus5.presenter.Presenter;
import nucleus5.view.NucleusAppCompatActivity;

public abstract class BaseActivity<P extends Presenter> extends NucleusAppCompatActivity<P> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initView();
        initData();
        initListener();
    }

    protected abstract void initLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

}
