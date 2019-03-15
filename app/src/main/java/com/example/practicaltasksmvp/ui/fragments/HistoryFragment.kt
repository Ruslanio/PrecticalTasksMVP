package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment

class HistoryFragment : BaseFragment() {
    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_history
    }
}