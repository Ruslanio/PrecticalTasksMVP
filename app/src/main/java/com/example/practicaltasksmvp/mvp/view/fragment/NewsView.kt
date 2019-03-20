package com.example.practicaltasksmvp.mvp.view.fragment

import com.arellomobile.mvp.MvpView
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.view.ProgressView

interface NewsView : MvpView , ProgressView{

    fun showArticles(articles : List<NewsArticleEntity>)

}