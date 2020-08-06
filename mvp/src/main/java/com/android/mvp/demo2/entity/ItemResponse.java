package com.android.mvp.demo2.entity;

import com.android.mvp.demo1.entity.Item;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {
    @SerializedName("value")
    public Item item;
}
