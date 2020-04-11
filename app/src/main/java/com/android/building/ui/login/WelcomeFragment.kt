package com.android.building.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.building.R
import com.android.building.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    lateinit var btnLogin: Button

    lateinit var btnRegister: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.welcome_fragment, container, false
            )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin = view.findViewById(R.id.btn_login);
        btnRegister = view.findViewById(R.id.btn_register)


        btnLogin.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        })


        btnRegister.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        })

    }
}