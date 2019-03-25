package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.data.local.realm.async.executors.HandlingExecutionCallback
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.view.fragment.NewsView
import com.example.practicaltasksmvp.navigation.NewsDetailsScreen
import ru.terrakok.cicerone.Router

@InjectViewState
class NewsPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<NewsView>() {


    fun getArticlesByCategoryId(categoryId: Long, forceLoad: Boolean) {
        val callback = HandlingExecutionCallback(this::onDataReceived, this::onLoadStart)
        return dataManager.getArticles(categoryId, forceLoad, callback)
    }


    private fun onDataReceived(data: List<NewsArticleEntity>) {
        viewState.showArticles(data)
        viewState.onProgressStop()
    }

    private fun onLoadStart() {
        viewState.onProgressStart()
    }

    fun onNewsClick(entity: NewsArticleEntity) {
        router.navigateTo(NewsDetailsScreen(entity.id))
    }
}