package com.example.practicaltasksmvp.di.modules.activity

import com.example.practicaltasksmvp.mvp.presenter.activity.MainPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
 class NewsDetailsActivityModule {

    @Provides
    @Inject
    fun providePresenter(router: Router): MainPresenter {
        return MainPresenter(router)
    }

}