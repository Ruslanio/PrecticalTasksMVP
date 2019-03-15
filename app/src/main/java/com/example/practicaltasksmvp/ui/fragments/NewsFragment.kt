package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.base.BaseView
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import com.example.practicaltasksmvp.mvp.view.fragment.NewsView

class NewsFragment : BaseFragment(), NewsView{
    companion object {
        const val KEY_CATEGORY_ID = "key_category_id"
        const val KEY_SCREEN_NAME = "key_screen_name"

        fun newInstance(screenName: String, categoryId: Long): Fragment {
            val fragment = NewsFragment()
            val bundle = Bundle()
            bundle.putLong(KEY_CATEGORY_ID, categoryId)
            bundle.putString(KEY_SCREEN_NAME, screenName)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.fragment_news
    }
}