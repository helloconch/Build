package com.android.mvp.demo1.entity;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("value")
    public Item[] items;
}
