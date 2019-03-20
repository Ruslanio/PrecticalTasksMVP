package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.HelpCategoryPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import javax.inject.Inject

class HelpCategoryFragment : BaseFragment(), HelpCategoryView {

    @Inject
    lateinit var presenter : HelpCategoryPresenter

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_help_categories
    }
}