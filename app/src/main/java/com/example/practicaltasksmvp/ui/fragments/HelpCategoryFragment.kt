package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import com.example.practicaltasksmvp.mvp.view.fragment.NewsView

class HelpCategoryFragment : BaseFragment(), HelpCategoryView {
    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_help_categories
    }
}