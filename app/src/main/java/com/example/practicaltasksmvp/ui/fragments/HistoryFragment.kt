package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.HistoryPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.HistoryView
import javax.inject.Inject

class HistoryFragment : BaseFragment<HistoryView, HistoryPresenter>(), HistoryView {


    @Inject
    @InjectPresenter
    override lateinit var presenter: HistoryPresenter

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_history
    }
}