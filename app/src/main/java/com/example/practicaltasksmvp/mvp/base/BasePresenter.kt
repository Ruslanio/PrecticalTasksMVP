package com.example.practicaltasksmvp.mvp.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {

}