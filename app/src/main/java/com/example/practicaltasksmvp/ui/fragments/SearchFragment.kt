package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.view.fragment.SearchView

class SearchFragment : BaseFragment(), SearchView {
    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search
    }
}