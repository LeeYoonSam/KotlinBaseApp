package com.ys.albertbaseproject.di.module

import com.ys.albertbaseproject.main.MainActivity
import com.ys.albertbaseproject.di.socpe.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActModule::class])
    abstract fun getMainActivity(): MainActivity
}