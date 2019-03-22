package com.example.practicaltasksmvp.mvp.view.fragment

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.practicaltasksmvp.mvp.view.ToastView
import com.example.practicaltasksmvp.util.EditProfileDialog

interface ProfileView : MvpView, ToastView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun showFragment(listener: EditProfileDialog.OnEditDialogClickListener, forceShow: Boolean)
}