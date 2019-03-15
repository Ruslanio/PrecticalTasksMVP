package com.example.practicaltasksmvp.mvp.base

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView


@InjectViewState
abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {

}