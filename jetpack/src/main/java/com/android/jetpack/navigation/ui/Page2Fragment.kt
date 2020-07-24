package com.android.jetpack.navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.android.jetpack.R
import com.android.jetpack.livedata.TestViewModel
import kotlinx.android.synthetic.main.layout_page2.*

class Page2Fragment : Fragment() {
    private lateinit var testViewModel: TestViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        click.setOnClickListener {
            //返回Page1Fragment
            Navigation.findNavController(it).navigateUp()
        }

        click2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_page3)
        }

        var nameObservale = Observer<String> {
            liveDataTV.text = it
        }

        testViewModel.myCurrent!!.observe(viewLifecycleOwner, nameObservale)

        liveDataBtn1.setOnClickListener {
            testViewModel.myCurrent!!.value = "hello AAA"
        }

        liveDataBtn2.setOnClickListener {
            testViewModel.myCurrent!!.value = "hello BBB"
        }


        val lowObservable = Observer<String> {
            liveDatalow.text = it
        }

        val lengthObservable = Observer<Int> {
            liveDataLen.text = it.toString()
        }

        testViewModel.liveDataMap.observe(viewLifecycleOwner, lengthObservable)
        testViewModel.livaDataSwich.observe(viewLifecycleOwner, lowObservable)
    }
}