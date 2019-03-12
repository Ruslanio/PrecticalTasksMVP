package com.example.practicaltasksmvp.mvp.presenter

import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.SplashView
import com.example.practicaltasksmvp.navigation.MainScreen
import ru.terrakok.cicerone.Router

class SplashPresenter(private val router: Router) : BasePresenter<SplashView>() {


    fun nextView(){
        router.navigateTo(MainScreen())
    }
}