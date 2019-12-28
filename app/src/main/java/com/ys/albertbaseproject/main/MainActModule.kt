package com.ys.albertbaseproject.main

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.ys.albertbaseproject.main.MainActivity
import com.ys.albertbaseproject.databinding.ActivityMainBinding
import com.ys.albertbaseproject.di.socpe.ActivityScope
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProviders
import com.ys.albertbaseproject.BaseViewModelFactory
import com.ys.albertbaseproject.R
import com.ys.albertbaseproject.data.source.DefaultPostRepository
import com.ys.albertbaseproject.di.ViewModelKey
import com.ys.albertbaseproject.main.MainViewModel
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import dagger.Binds
import dagger.multibindings.IntoMap

@Module
@Suppress("UNUSED")
abstract class MainActModule {
    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [MainViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindLaunchViewModel(viewModel: MainViewModel): ViewModel
}