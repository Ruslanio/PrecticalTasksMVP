package com.example.practicaltasksmvp.mvp.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.practicaltasksmvp.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), BaseView, HasSupportFragmentInjector {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    protected var navigator: Navigator = SupportAppNavigator(this, R.id.containerMain)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        AndroidInjection.inject(this)
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