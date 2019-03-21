package com.example.practicaltasksmvp.mvp.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.moxy.MoxyActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseActivity<V : MvpView, P : MvpPresenter<V>> : MoxyActivity(), BaseView,
    HasSupportFragmentInjector {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    abstract var presenter: P

    @ProvidePresenter
    fun providePresenter() : P = presenter

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    protected var navigator: Navigator = SupportAppNavigator(this, R.id.containerMain)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        onInit(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (navigator != null)
            navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}