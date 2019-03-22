package com.example.practicaltasksmvp.mvp.presenter.activity

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.practicaltasksmvp.mvp.view.activity.SplashView
import com.example.practicaltasksmvp.navigation.MainScreen
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(private val router: Router) : MvpPresenter<SplashView>() {

    fun nextView(){
        router.navigateTo(MainScreen())
    }
}