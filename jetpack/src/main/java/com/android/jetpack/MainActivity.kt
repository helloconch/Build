package com.android.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.android.jetpack.lifecycle.MyDataView
import com.android.jetpack.lifecycle.presenter.BasePresenter
import com.android.jetpack.lifecycle.presenter.DataPresenter
import com.android.jetpack.lifecycle.presenter.IPresenter

class MainActivity : AppCompatActivity() {
    val presenter: IPresenter = BasePresenter()
    val myDataView:MyDataView= MyDataView()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(presenter)

        myDataView.create()
        myDataView.start()
        myDataView.destory()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.my_nav_host_fragment).navigateUp()
    }
}
