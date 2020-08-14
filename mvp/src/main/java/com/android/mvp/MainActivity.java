package com.android.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mvp.demo1.Demo1Activity;
import com.android.mvp.demo2.Demo2Activity;
import com.android.mvp.demo3.Demo3Activity;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    TextView contentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentTV = findViewById(R.id.contentTV);

        findViewById(R.id.btn1).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo1Activity.class)));


        findViewById(R.id.btn2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo2Activity.class)));


        findViewById(R.id.btn3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Demo3Activity.class)));

        Observable.concat(localObservable(), remoteObservable())
                .subscribe(s -> {
                });

    }

    Observable<String> localObservable() {
        return Observable.create(s -> {
            s.onNext("hello local");
            s.onComplete();
        });

    }

    Observable<String> remoteObservable() {
        return Observable.create(s -> {
            s.onNext("hello remote");
        });
    }
}
