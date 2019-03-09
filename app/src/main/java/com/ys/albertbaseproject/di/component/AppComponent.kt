package com.ys.albertbaseproject.di.component

import com.ys.albertbaseproject.Application
import com.ys.albertbaseproject.di.module.ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import java.util.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ActivityModule::class))
interface AppComponent: AndroidInjector<Application> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<Application>()
}