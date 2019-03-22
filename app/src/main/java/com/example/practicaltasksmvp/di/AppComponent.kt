package com.example.practicaltasksmvp.di

import android.app.Application
import com.example.practicaltasksmvp.di.builder.ActivityBuilder
import com.example.practicaltasksmvp.di.modules.app.ContextModule
import com.example.practicaltasksmvp.di.modules.app.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, MainModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun contextModule(module: ContextModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: DaggerApplication)
}