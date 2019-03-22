package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchView
import dagger.Lazy
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView {

    @Inject
    override lateinit var daggerPresenter: Lazy<SearchPresenter>

    @InjectPresenter
    override lateinit var presenter: SearchPresenter

    @ProvidePresenter
    override fun providePresenter(): SearchPresenter = daggerPresenter.get()

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search
    }
}