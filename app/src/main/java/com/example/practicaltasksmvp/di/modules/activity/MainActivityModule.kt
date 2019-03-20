package com.example.practicaltasksmvp.di.modules.activity

import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.di.scopes.ActivityScope
import com.example.practicaltasksmvp.mvp.presenter.activity.MainPresenter
import com.example.practicaltasksmvp.ui.activities.MainActivity
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    @Inject
    fun providePresenter(router: Router, context: MainActivity): MainPresenter {
        val defaultScreenName = context.resources.getString(R.string.news)
        return MainPresenter(router, defaultScreenName)
    }

}