package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.FragmentPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class FragmentModule {

    @Inject
    @ActivityScope
    @Provides
    fun providePresenter(router: Router, dataManager: DataManager): FragmentPresenter {
        return FragmentPresenter(router, dataManager)
    }
}