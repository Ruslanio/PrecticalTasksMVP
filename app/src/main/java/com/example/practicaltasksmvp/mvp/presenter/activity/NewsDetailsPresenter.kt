package com.example.practicaltasksmvp.mvp.presenter.activity

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.data.local.realm.async.executors.HandlingExecutionCallback
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.model.PhoneEntity
import com.example.practicaltasksmvp.mvp.view.activity.NewsDetailsView
import ru.terrakok.cicerone.Router

@InjectViewState
class NewsDetailsPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<NewsDetailsView>() {


    fun getArticle(forceLoad: Boolean, id: Long) {
        val callback = HandlingExecutionCallback(this::onDataReceived, this::onLoadStart)
        return dataManager.getArticleById(id, forceLoad, callback)
    }


    fun printNumbers(numbers: List<PhoneEntity>): String {
        val builder = StringBuilder()
        for (phone in numbers) {
            builder.append(phone.number).append("\n")
        }
        return builder.toString()
    }


    private fun onDataReceived(data: NewsArticleEntity) {
        viewState.showArticle(data)
        viewState.onProgressStop()
    }

    private fun onLoadStart() {
        viewState.onProgressStart()
    }

    fun close(){
        viewState.finishView()
    }
}