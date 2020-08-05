package com.android.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mvp.demo1.Demo1Activity;
import com.android.mvp.demo2.Demo2Activity;
import com.android.mvp.demo3.Demo3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo1Activity.class)));


        findViewById(R.id.btn2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo2Activity.class)));


        findViewById(R.id.btn3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo3Activity.class)));


    }
}
