package com.example.practicaltasksmvp.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpView
import com.example.practicaltasksmvp.mvp.base.moxy.MoxyFragment
import dagger.Lazy
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<V : MvpView, P : BasePresenter<V>> : MoxyFragment(), BaseView {


    abstract var presenter: P

    abstract var daggerPresenter: Lazy<P>

    abstract fun providePresenter(): P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}