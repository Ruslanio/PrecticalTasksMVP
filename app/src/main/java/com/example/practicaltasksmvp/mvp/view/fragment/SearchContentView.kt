package com.example.practicaltasksmvp.mvp.view.fragment

import com.arellomobile.mvp.MvpView

interface SearchContentView : MvpView {

    fun showData(data: List<String>)
}