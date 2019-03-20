package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import ru.terrakok.cicerone.Router

class SearchPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<HelpCategoryView>() {

}