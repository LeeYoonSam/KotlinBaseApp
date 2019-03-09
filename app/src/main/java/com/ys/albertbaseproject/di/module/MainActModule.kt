package com.ys.albertbaseproject.di.module

import androidx.databinding.DataBindingUtil
import com.ys.albertbaseproject.main.MainActivity
import com.ys.albertbaseproject.databinding.ActivityMainBinding
import com.ys.albertbaseproject.di.socpe.ActivityScope
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ys.albertbaseproject.main.MainViewModel


@Module
abstract class MainActModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainActBinding(activity: MainActivity) : ActivityMainBinding {
            return DataBindingUtil.setContentView(activity, com.ys.albertbaseproject.R.layout.activity_main)
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainViewModel(activity: MainActivity): MainViewModel {
            return ViewModelProviders.of(activity, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel() as T
                }
            }).get(MainViewModel::class.java)
        }
    }
}