package com.ys.albertbaseproject.di.module

import android.content.Context
import com.ys.albertbaseproject.storage.SharedPreferenceStorageImpl
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import com.ys.albertbaseproject.storage.Storage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class StorageModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideSharedPreferenceStorage(context: Context): SharedPreferenceStorage {
            return SharedPreferenceStorageImpl(context)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideStorage(sharedPreferenceStorage: SharedPreferenceStorage): Storage {
            return sharedPreferenceStorage
        }
    }
}