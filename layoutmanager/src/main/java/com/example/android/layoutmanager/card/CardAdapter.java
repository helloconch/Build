package com.example.android.layoutmanager.card;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.android.layoutmanager.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ItemViewHolder> {


    private Context mContext;
    private List<CardBean> mDataList;

    public CardAdapter(Context context, List<CardBean> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        CardBean item = mDataList.get(position);
        holder.textTitle.setText(item.getTitle());
        Picasso.with(holder.imageUrl.getContext()).load(item.getResourceId()).into(holder.imageUrl);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageUrl;
        TextView textTitle;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.image_item_flag);
            textTitle = itemView.findViewById(R.id.text_item_title);
        }
    }

}
