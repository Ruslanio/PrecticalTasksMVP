package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.data.local.realm.async.executors.HandlingExecutionCallback
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import com.example.practicaltasksmvp.navigation.NewsScreen
import ru.terrakok.cicerone.Router

@InjectViewState
class HelpCategoryPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<HelpCategoryView>() {

    fun openRelatedNews(name: String, id: Long) {
        router.navigateTo(NewsScreen(name, id))
    }

    fun getCategories(forceLoad: Boolean) {
        val callback = HandlingExecutionCallback<List<HelpCategoryEntity>>(this::onDataReceived, this::onLoadStart)
        return dataManager.getCategories(forceLoad, callback)
    }

    private fun onDataReceived(data: List<HelpCategoryEntity>?) {
        viewState.showCategories(data)
        viewState.onProgressStop()
    }

    private fun onLoadStart() {
        viewState.onProgressStart()
    }
}