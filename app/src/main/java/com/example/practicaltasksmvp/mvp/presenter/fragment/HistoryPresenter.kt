package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.HistoryView
import ru.terrakok.cicerone.Router

@InjectViewState
class HistoryPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<HistoryView>() {

}