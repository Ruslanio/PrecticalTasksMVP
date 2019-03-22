package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import android.os.Handler
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.presenter.activity.SplashPresenter
import com.example.practicaltasksmvp.mvp.view.activity.SplashView
import dagger.Lazy
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {

    @ProvidePresenter
    override fun providePresenter(): SplashPresenter = daggerPresenter.get()

    @Inject
    override lateinit var daggerPresenter: Lazy<SplashPresenter>

    @InjectPresenter
    override lateinit var presenter: SplashPresenter

    override fun onInit(savedInstanceState: Bundle?) {
        Handler().postDelayed(
            { presenter.nextView() }, 1000
        )
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }
}