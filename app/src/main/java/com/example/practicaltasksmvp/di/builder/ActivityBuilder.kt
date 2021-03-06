package com.example.practicaltasksmvp.di.builder

import com.example.practicaltasksmvp.di.modules.activity.MainActivityModule
import com.example.practicaltasksmvp.di.modules.activity.SplashActivityModule
import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.ui.activities.MainActivity
import com.example.practicaltasksmvp.ui.activities.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}