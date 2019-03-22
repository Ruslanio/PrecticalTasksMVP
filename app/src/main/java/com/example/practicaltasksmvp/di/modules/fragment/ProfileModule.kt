package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.ProfilePresenter
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {

    @FragmentScope
    @Provides
    fun providePresenter(): ProfilePresenter {
        return ProfilePresenter()
    }
}