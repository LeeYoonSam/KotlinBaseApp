package com.ys.albertbaseproject.main

import com.ys.albertbaseproject.BaseViewModel
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import javax.inject.Inject

class MainViewModel @Inject constructor(private val sharedPreferenceStorage: SharedPreferenceStorage) : BaseViewModel() {
    fun getTestPrint() = println("call test print")

    fun testSavePreference() {
        sharedPreferenceStorage.put("key", "test")
        println("success test save")
    }

    fun testGetPreference() {
        println(sharedPreferenceStorage.getString("key"))
    }
}