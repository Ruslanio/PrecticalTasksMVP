package com.example.practicaltasksmvp.di.modules.app

import android.content.Context
import com.example.practicaltasksmvp.PracticalMvpApp
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ContextModule {

    @Provides
    @Inject
    fun provideContext(app: PracticalMvpApp): Context {
        return app.applicationContext
    }
}