package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.presenter.activity.SplashPresenter
import com.example.practicaltasksmvp.mvp.view.activity.SplashView
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {

    override fun show() {
        Toast.makeText(this, "!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
    }

    @Inject
    @InjectPresenter
    override lateinit var presenter: SplashPresenter

    override fun onInit(savedInstanceState: Bundle?) {
        presenter.test()
        Handler().postDelayed(
            { presenter.nextView() }, 1000
        )
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }
}