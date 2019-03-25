package com.example.practicaltasksmvp.mvp.view.fragment

import com.arellomobile.mvp.MvpView
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.view.ProgressView

interface HelpCategoryView : MvpView, ProgressView {

    fun showCategories(data : List<HelpCategoryEntity>?)
}