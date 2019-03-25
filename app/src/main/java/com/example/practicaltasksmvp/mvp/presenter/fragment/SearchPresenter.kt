package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasks.util.rxbus.RxBus
import com.example.practicaltasks.util.rxbus.RxBusEvents
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchView

@InjectViewState
class SearchPresenter() : BasePresenter<SearchView>() {

    fun publish(position: Int) {
        RxBus.publish(RxBusEvents.EventViewPagerOnFragmentVisible(position))
    }
}