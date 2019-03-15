package com.example.practicaltasksmvp.di.modules.activity

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.mvp.presenter.activity.MainPresenter
import com.example.practicaltasksmvp.mvp.presenter.activity.NewsDetailsPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class NewsDetailsActivityModule {

    @Provides
    @Inject
    fun providePresenter(router: Router, dataManager: DataManager): NewsDetailsPresenter {
        return NewsDetailsPresenter(router, dataManager)
    }

}