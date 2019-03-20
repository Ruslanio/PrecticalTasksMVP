package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.ProfilePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.ProfileView
import javax.inject.Inject

class ProfileFragment : BaseFragment(), ProfileView {
    @Inject
    lateinit var presenter: ProfilePresenter

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_profile
    }
}