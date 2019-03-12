package com.example.practicaltasksmvp.mvp.presenter

import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.MainView
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router) : BasePresenter<MainView>() {
}