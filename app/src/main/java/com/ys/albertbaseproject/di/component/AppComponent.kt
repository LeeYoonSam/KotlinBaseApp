package com.ys.albertbaseproject.di.component

import com.ys.albertbaseproject.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class))
interface AppComponent: AndroidInjector<Application> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<Application>()
}