package com.example.practicaltasksmvp.mvp.presenter.activity

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.ui.activities.NewsDetailsActivity
import ru.terrakok.cicerone.Router

class NewsDetailsPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<NewsDetailsActivity>() {

}