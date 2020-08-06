package com.android.mvp.demo2.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.mvp.demo2.action.Action1;


public class SimpleViewHolder<T> extends BaseViewHolder<T> {
    private final TextView textView;
    private T item;


    public SimpleViewHolder(@NonNull View itemView, final Action1<T> action) {
        super(itemView);
        textView = itemView.findViewById(android.R.id.text1);
        textView.setOnClickListener(v -> {
            action.call(item);
        });
    }

    @Override
    public void bind(T item) {
        this.item = item;
        textView.setText(item.toString());
    }
}
