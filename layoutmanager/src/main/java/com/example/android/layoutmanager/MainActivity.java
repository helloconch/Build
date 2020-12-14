package com.example.android.layoutmanager;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.layoutmanager.card.CardActivity;
import com.example.android.layoutmanager.table.TableActivity;


public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.button_card_layout_manager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardActivity.startUp(mContext);
            }
        });

        findViewById(R.id.button_table_layout_manager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableActivity.startUp(mContext);
            }
        });

    }
}
