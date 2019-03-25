package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchPresenter
import dagger.Module
import dagger.Provides

@Module
class SearchModule {


    @FragmentScope
    @Provides
    fun providePresenter(): SearchPresenter {
        return SearchPresenter()
    }
}