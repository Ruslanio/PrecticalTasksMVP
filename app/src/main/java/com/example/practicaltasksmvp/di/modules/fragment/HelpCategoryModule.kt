package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.HelpCategoryPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class HelpCategoryModule {

    @Inject
    @FragmentScope
    @Provides
    fun providePresenter(router: Router, dataManager: DataManager): HelpCategoryPresenter {
        return HelpCategoryPresenter(router, dataManager)
    }
}