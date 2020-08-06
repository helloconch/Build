package com.android.mvp.demo2.util;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mvp.Constants;
import com.android.mvp.demo2.action.Action0;

public class OnScrollPaging extends RecyclerView.OnScrollListener {


    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private Action0 requestNext;

    public OnScrollPaging(LinearLayoutManager layoutManager,
                          RecyclerView.Adapter adapter,
                          Action0 requestNext) {
        this.layoutManager = layoutManager;
        this.adapter = adapter;
        this.requestNext = requestNext;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        int visibleItemCount = recyclerView.getChildCount();
        int loadedItemCount = adapter.getItemCount();
        int firstVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition();

        Log.i(Constants.TAG, String.format("loadedItemCount:%d  firstVisibleItem:%d visibleItemCount:%d",
                loadedItemCount, firstVisibleItem, visibleItemCount));

        if (loadedItemCount - firstVisibleItem - visibleItemCount < 3) {
            requestNext.call();
        }
    }
}
