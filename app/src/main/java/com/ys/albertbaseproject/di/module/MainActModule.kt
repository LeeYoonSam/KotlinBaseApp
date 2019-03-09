package com.ys.albertbaseproject.di.module

import androidx.databinding.DataBindingUtil
import com.ys.albertbaseproject.MainActivity
import com.ys.albertbaseproject.R
import com.ys.albertbaseproject.databinding.ActivityMainBinding
import com.ys.albertbaseproject.di.socpe.ActivityScope
import dagger.Module
import dagger.Provides

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
    }
}