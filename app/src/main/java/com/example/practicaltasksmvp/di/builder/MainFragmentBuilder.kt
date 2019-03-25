package com.example.practicaltasksmvp.di.builder

import com.example.practicaltasksmvp.di.modules.fragment.*
import com.example.practicaltasksmvp.di.scopes.FragmentScope
import com.example.practicaltasksmvp.ui.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsModule::class])
    abstract fun bindNewsFragment(): NewsFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HelpCategoryModule::class])
    abstract fun bindHelpCategoryFragment(): HelpCategoryFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HistoryModule::class])
    abstract fun bindHistoryFragment(): HistoryFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun bindSearchFragment(): SearchFragment

}