package com.android.jetpack.navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.android.jetpack.R
import com.android.jetpack.viewmodel.UserModel
import kotlinx.android.synthetic.main.layout_page1.*

class Page1Fragment : Fragment() {
    private lateinit var userModel: UserModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userModel = ViewModelProviders.of(this).get(UserModel::class.java)
        click.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_page2)
        }


        changeUserInfo.setOnClickListener {
            userinfo.text = userModel.name + ":" + userModel.age
        }
    }
}