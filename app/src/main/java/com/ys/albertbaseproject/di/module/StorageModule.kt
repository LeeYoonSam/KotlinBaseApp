package com.ys.albertbaseproject.di.module

import com.ys.albertbaseproject.storage.SharedPreference
import com.ys.albertbaseproject.storage.Storage
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    fun provideStorage() : Storage {
        return SharedPreference()
    }
}