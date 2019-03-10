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
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import com.ys.albertbaseproject.storage.SharedPreferenceStorageImpl

@Module
abstract class MainActModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainActBinding(activity: MainActivity) : ActivityMainBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_main)
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainViewModel(activity: MainActivity): MainViewModel {
//            return ViewModelProviders.of(activity, BaseViewModelFactory { MainViewModel(storage) }).get(MainViewModel::class.java)
            return ViewModelProviders
                .of(activity, BaseViewModelFactory { MainViewModel(SharedPreferenceStorageImpl(activity.applicationContext)) } )
                .get(MainViewModel::class.java)
        }
    }
}