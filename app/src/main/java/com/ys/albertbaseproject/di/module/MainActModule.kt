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

@Module
class MainActModule {
    @Provides
    @ActivityScope
    fun provideMainActBinding(mainActivity: MainActivity) : ActivityMainBinding {
        return DataBindingUtil.setContentView(mainActivity, R.layout.activity_main)
    }

    @Provides
    @ActivityScope
    fun provideMainViewModel(mainActivity: MainActivity, storage: SharedPreferenceStorage, apiService: ApiService): MainViewModel {
        return ViewModelProviders
            .of(mainActivity, BaseViewModelFactory { MainViewModel(storage, apiService) } )
            .get(MainViewModel::class.java)
    }
}