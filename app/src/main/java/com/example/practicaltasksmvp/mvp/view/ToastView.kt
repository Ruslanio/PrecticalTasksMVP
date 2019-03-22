package com.example.practicaltasksmvp.mvp.view

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ToastView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun showToast(msg: String)
}