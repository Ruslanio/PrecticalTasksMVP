package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import android.os.Handler
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.presenter.activity.SplashPresenter
import com.example.practicaltasksmvp.mvp.view.activity.SplashView
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var presenter: SplashPresenter

    override fun onInit(savedInstanceState: Bundle?) {
        Handler().postDelayed(
            { presenter.nextView() }, 2000
        )
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }
}