package com.example.practicaltasksmvp.di.modules.activity

import android.content.Context
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.presenter.activity.MainPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Module
 class MainActivityModule {

    @Provides
    @Inject
    fun providePresenter(router: Router, context: Context): MainPresenter {
        val defaultScreenName = context.resources.getString(R.string.news)
        return MainPresenter(router, defaultScreenName)
    }



}