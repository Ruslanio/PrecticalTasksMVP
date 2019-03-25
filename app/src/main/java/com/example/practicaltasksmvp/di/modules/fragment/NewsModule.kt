package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.NewsPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class NewsModule {

    @Inject
    @FragmentScope
    @Provides
    fun providePresenter(router: Router, dataManager: DataManager): NewsPresenter {
        return NewsPresenter(router, dataManager)
    }
}