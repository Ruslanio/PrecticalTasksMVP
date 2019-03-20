package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.ProfilePresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class ProfileModule {

    @Inject
    @FragmentScope
    @Provides
    fun providePresenter(router: Router, dataManager: DataManager): ProfilePresenter {
        return ProfilePresenter(router, dataManager)
    }
}