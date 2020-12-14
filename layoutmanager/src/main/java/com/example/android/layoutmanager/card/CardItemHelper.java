package com.example.android.layoutmanager.card;


import androidx.recyclerview.widget.RecyclerView;

public interface CardItemHelper {

    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);

}
