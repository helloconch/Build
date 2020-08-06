package com.android.mvp.demo2.adapter;

import android.view.ViewGroup;

public interface ViewHolderType<T> {
    boolean isOfItem(Object item);

    BaseViewHolder<T> create(ViewGroup parent);
}
