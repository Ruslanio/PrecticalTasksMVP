package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchContentPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchContentView
import javax.inject.Inject

class SearchContentFragment : BaseFragment(), SearchContentView {

    companion object {
        const val KEY_TAB_NUM = "key_tab_num"
        const val TEST_RESULTS_NUM = 4

        fun newInstance(tabNum: Int): Fragment {
            val fragment = SearchContentFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_TAB_NUM, tabNum)
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var presenter: SearchContentPresenter

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search_content
    }
}