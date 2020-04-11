package com.android.building.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()

    init {
        _name.value = "hello beijing"
    }

    val name: LiveData<String> = _name

}