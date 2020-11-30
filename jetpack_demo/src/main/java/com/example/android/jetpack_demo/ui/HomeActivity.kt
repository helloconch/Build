package com.example.android.jetpack_demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.jetpack_demo.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_coordinator1)
    }
}