package com.ys.albertbaseproject.di.component

import com.ys.albertbaseproject.App
import com.ys.albertbaseproject.di.module.ActivityModule
import com.ys.albertbaseproject.di.module.StorageModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ActivityModule::class, StorageModule::class))
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun application(app: App): AppComponent.Builder

        abstract override fun build(): AppComponent
    }
}
