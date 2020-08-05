package com.android.mvp.demo1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.mvp.R;
import com.android.mvp.demo1.entity.Item;
import com.android.mvp.demo1.presenter.Demo1Presenter;

import nucleus5.factory.RequiresPresenter;
import nucleus5.view.NucleusAppCompatActivity;

@RequiresPresenter(Demo1Presenter.class)
public class Demo1Activity extends NucleusAppCompatActivity<Demo1Presenter> {
    ArrayAdapter<Item> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        listView = findViewById(R.id.listView);
        findViewById(R.id.btn1).setOnClickListener(view -> {
            getPresenter().request(Demo1Presenter.NAME_1);
        });

        findViewById(R.id.btn2).setOnClickListener(view -> {
            getPresenter().request(Demo1Presenter.NAME_2);
        });

        adapter = new ArrayAdapter<>(this, R.layout.item);
        listView.setAdapter(adapter);

        if (savedInstanceState == null) {
            getPresenter().request(Demo1Presenter.NAME_1);
        }


    }

    public void addItems(Item[] items) {
        if (items != null) {
            adapter.clear();
            adapter.addAll(items);
        }
    }

    public void onNetworkError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
