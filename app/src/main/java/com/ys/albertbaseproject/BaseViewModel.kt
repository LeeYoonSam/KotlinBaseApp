package com.ys.albertbaseproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _loading = MutableLiveData<Boolean>(false)
    val loading = _loading
}