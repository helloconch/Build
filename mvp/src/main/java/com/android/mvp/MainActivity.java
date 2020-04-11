package com.android.mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nucleus5.factory.RequiresPresenter;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter> implements IEvent {
    private TextView content;
    private Button one;
    private Button two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        content = findViewById(R.id.content);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().load("xiaoming", 0);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().load("zhangsan", 1);
            }
        });
    }

    public void loginSuccess(String result) {
        Toast.makeText(this, "Success:" + result, Toast.LENGTH_SHORT).show();
    }

    public void loginFailed() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        Log.i("AYADSFSF", content);
    }

    @Override
    public void error(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        Log.i("AYADSFSF", content);
    }
}
