package com.android.building.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.building.R
import com.android.building.databinding.MainFragmentBinding
import com.android.order.OrderMainActivity


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        binding.messageContent = "hello"


        binding.orderBtn?.setOnClickListener(View.OnClickListener {

            val intent = Intent(context, OrderMainActivity::class.java)

            context?.startActivity(intent)

        })

        val displayMetrics: DisplayMetrics = activity!!.resources.displayMetrics
        Log.i(
            "AABBCCDD", String.format(
                "width:%d height:%d density:%s densityDpi:%s",
                displayMetrics.widthPixels,
                displayMetrics.heightPixels,
                displayMetrics.density.toString(),
                displayMetrics.densityDpi.toString()
            )
        )

        val typedValue = TypedValue()
        activity!!.resources.getValue(R.drawable.abc, typedValue, true)
        val density = typedValue.density
        val path = typedValue.string.toString()

        val drawable = activity!!.resources.getDrawable(R.drawable.test)
        val intrinsicWidth = drawable.intrinsicWidth
        val intrinsicHeight = drawable.intrinsicHeight


        Log.i(
            "AABBCCDD", String.format(
                "density:%d path:%s width:%d  height:%d ",
                density, path, intrinsicWidth, intrinsicHeight
            )
        )

        binding.pic.setImageResource(R.drawable.test)

    }


}
