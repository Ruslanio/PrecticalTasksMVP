package com.example.practicaltasksmvp.di.builder

import com.example.practicaltasksmvp.di.modules.fragment.*
import com.example.practicaltasksmvp.ui.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindNewsFragment(): NewsFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindHelpCategoryFragment(): HelpCategoryFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindHistoryFragment(): HistoryFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindSearchContentFragment(): SearchContentFragment
}