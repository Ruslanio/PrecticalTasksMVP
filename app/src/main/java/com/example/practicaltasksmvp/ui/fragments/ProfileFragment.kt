package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.ProfilePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.ProfileView
import dagger.Lazy
import javax.inject.Inject

class ProfileFragment : BaseFragment<ProfileView, ProfilePresenter>(), ProfileView {

    @ProvidePresenter
    override fun providePresenter(): ProfilePresenter = daggerPresenter.get()

    @InjectPresenter
    override lateinit var presenter: ProfilePresenter

    @Inject
    override lateinit var daggerPresenter: Lazy<ProfilePresenter>

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_profile
    }
}