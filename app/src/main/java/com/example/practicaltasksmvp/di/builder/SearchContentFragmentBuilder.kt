package com.example.practicaltasksmvp.di.builder

import com.example.practicaltasksmvp.di.modules.fragment.SearchContentModule
import com.example.practicaltasksmvp.di.scopes.SearchScope
import com.example.practicaltasksmvp.ui.fragments.SearchContentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchContentFragmentBuilder {

    @SearchScope
    @ContributesAndroidInjector(modules = [SearchContentModule::class])
    abstract fun bindSearchContentFragment(): SearchContentFragment

}