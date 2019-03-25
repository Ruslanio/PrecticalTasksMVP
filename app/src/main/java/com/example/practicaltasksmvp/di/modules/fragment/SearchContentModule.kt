package com.example.practicaltasksmvp.di.modules.fragment

import com.example.practicaltasksmvp.di.scopes.SearchScope
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchContentPresenter
import dagger.Module
import dagger.Provides

@Module
class SearchContentModule {

    @SearchScope
    @Provides
    fun providePresenter(): SearchContentPresenter {
        return SearchContentPresenter()
    }
}