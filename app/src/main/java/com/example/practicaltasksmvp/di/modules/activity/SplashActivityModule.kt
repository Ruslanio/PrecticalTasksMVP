package com.example.practicaltasksmvp.di.modules.activity

import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.mvp.presenter.activity.SplashPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
 class SplashActivityModule {

    @ActivityScope
    @Provides
    @Inject
    fun providePresenter(router: Router): SplashPresenter {
        return SplashPresenter(router)
    }
}