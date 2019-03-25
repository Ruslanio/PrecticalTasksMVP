package com.example.practicaltasksmvp.mvp.view.activity

import com.arellomobile.mvp.MvpView
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.view.Finishable
import com.example.practicaltasksmvp.mvp.view.ProgressView

interface NewsDetailsView  : MvpView , ProgressView, Finishable{
    fun showArticle(newsArticle : NewsArticleEntity?)
}