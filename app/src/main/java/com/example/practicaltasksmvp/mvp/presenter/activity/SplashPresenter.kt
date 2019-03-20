package com.example.practicaltasksmvp.mvp.presenter.activity

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.activity.SplashView
import com.example.practicaltasksmvp.navigation.MainScreen
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(private val router: Router) : BasePresenter<SplashView>() {


    fun nextView(){
        router.navigateTo(MainScreen())
    }
}