package com.example.practicaltasksmvp.mvp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

    fun onInit(savedInstanceState: Bundle?)

    @LayoutRes
    fun layoutId(): Int
}