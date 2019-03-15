package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import ru.terrakok.cicerone.Router

class FragmentPresenter(private val router: Router, private val dataManager: DataManager) :
    BasePresenter<BaseFragment>() {

}