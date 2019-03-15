package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment

class SearchContentFragment : BaseFragment() {

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

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search_content
    }
}