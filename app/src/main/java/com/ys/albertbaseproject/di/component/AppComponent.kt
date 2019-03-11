package com.ys.albertbaseproject.di.component

import android.app.Application
import com.ys.albertbaseproject.App
import com.ys.albertbaseproject.di.NetworkModule
import com.ys.albertbaseproject.di.builder.ActivityModule
import com.ys.albertbaseproject.di.StorageModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, NetworkModule::class, StorageModule::class])
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract override fun build(): AppComponent
    }
}
