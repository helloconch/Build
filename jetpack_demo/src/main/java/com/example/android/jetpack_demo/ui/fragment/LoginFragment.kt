package com.example.android.jetpack_demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.jetpack_demo.R
import com.example.android.jetpack_demo.model.LoginModel

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        //viewModel=ViewModelProviders.
        return view
    }
}