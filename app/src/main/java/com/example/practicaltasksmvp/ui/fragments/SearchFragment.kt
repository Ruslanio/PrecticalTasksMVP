package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchView
import javax.inject.Inject

class SearchFragment : BaseFragment(), SearchView {

    @Inject
    lateinit var presenter: SearchPresenter

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search
    }
}