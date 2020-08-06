package com.android.mvp.demo2.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final List<ViewHolderType> types;

    protected abstract List<?> getItems();

    public BaseRecyclerViewAdapter(ViewHolderType... types) {
        this.types = Collections.unmodifiableList(Arrays.asList(types));
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return types.get(viewType).create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(getItems().get(position));
    }

    @Override
    public int getItemViewType(int position) {
        Object item = getItems().get(position);
        for (int t = 0, size = types.size(); t < size; t++) {
            if (types.get(t).isOfItem(item)) {
                return t;
            }
        }
        throw new IllegalStateException("No view holder is registered for item: "
                + item + " at position: " + position);
    }

    @Override
    public int getItemCount() {
        return getItems().size();
    }
}
