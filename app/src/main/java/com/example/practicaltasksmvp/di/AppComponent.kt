package com.example.practicaltasksmvp.di

import android.app.Application
import com.example.practicaltasksmvp.PracticalMvpApp
import com.example.practicaltasksmvp.di.builder.ActivityBuilder
import com.example.practicaltasksmvp.di.modules.app.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, MainModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: PracticalMvpApp)
}