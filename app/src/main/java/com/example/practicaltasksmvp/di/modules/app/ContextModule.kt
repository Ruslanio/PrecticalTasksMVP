package com.example.practicaltasksmvp.di.modules.app

import android.content.Context
import com.example.practicaltasksmvp.PracticalMvpApp
import com.example.practicaltasksmvp.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val app: PracticalMvpApp) {


    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }
}