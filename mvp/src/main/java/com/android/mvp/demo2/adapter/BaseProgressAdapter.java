package com.android.mvp.demo2.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class BaseProgressAdapter extends BaseRecyclerViewAdapter {

    private final int progressViewId;
    private boolean progress;

    public BaseProgressAdapter(int progressViewId, ViewHolderType... types) {
        super(types);
        this.progressViewId = progressViewId;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == progressViewId) {
            return new EmptyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(progressViewId, parent, false));
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (position != super.getItemCount()) {
            holder.bind(getItems().get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == super.getItemCount()) {
            return progressViewId;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + (progress ? 1 : 0);
    }

    public void showProgress() {
        if (!progress) {
            progress = true;
            notifyItemInserted(getItemCount());
        }
    }

    public void hideProgress() {
        if (progress) {
            progress = false;
            notifyItemRemoved(getItemCount());
        }
    }
}
