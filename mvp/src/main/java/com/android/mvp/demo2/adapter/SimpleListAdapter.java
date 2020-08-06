package com.android.mvp.demo2.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleListAdapter<T> extends BaseProgressAdapter {

    private List<T> items = Collections.emptyList();

    public SimpleListAdapter(ViewHolderType... types) {
        super(0, types);
    }

    public SimpleListAdapter(int progressViewId, ViewHolderType... types) {
        super(progressViewId, types);
    }

    public void set(List<T> items) {
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        notifyDataSetChanged();
    }

    public void add(List<T> items) {
        int preSize = this.items.size();
        List<T> list = new ArrayList<>(preSize + items.size());
        list.addAll(this.items);
        list.addAll(items);
        this.items = Collections.unmodifiableList(list);
        notifyItemRangeChanged(preSize, items.size());
    }


    public void clear() {
        this.items = Collections.emptyList();
        notifyDataSetChanged();
    }

    public T get(int pos) {
        return items.get(pos);
    }

    @Override
    protected List<T> getItems() {
        return items;
    }
}
