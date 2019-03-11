package com.ys.albertbaseproject.di.module

import androidx.databinding.DataBindingUtil
import com.ys.albertbaseproject.main.MainActivity
import com.ys.albertbaseproject.databinding.ActivityMainBinding
import com.ys.albertbaseproject.di.socpe.ActivityScope
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProviders
import com.ys.albertbaseproject.BaseViewModelFactory
import com.ys.albertbaseproject.R
import com.ys.albertbaseproject.main.MainViewModel
import com.ys.albertbaseproject.network.ApiService
import com.ys.albertbaseproject.storage.SharedPreferenceStorageImpl

@Module
class MainActModule {
    @Provides
    @ActivityScope
    fun provideMainActBinding(mainActivity: MainActivity) : ActivityMainBinding {
        return DataBindingUtil.setContentView(mainActivity, R.layout.activity_main)
    }

    @Provides
    @ActivityScope
    fun provideMainViewModel(mainActivity: MainActivity, apiService: ApiService): MainViewModel {
//        fun provideMainViewModel(activity: MainActivity): MainViewModel {
//            return ViewModelProviders.of(activity, BaseViewModelFactory { MainViewModel(storage) }).get(MainViewModel::class.java)
        return ViewModelProviders
            .of(mainActivity, BaseViewModelFactory { MainViewModel(SharedPreferenceStorageImpl(mainActivity.applicationContext), apiService) } )
            .get(MainViewModel::class.java)
    }

}