package com.example.practicaltasksmvp.di.modules.activity

import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.mvp.presenter.SplashPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
 class SplashActivityModule {

    @Provides
    @Inject
    fun providePresenter(router: Router): SplashPresenter {
        return SplashPresenter(router)
    }
}