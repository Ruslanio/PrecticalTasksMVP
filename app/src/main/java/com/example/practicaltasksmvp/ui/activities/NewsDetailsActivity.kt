package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.presenter.activity.NewsDetailsPresenter
import com.example.practicaltasksmvp.mvp.view.activity.NewsDetailsView

class NewsDetailsActivity : BaseActivity<NewsDetailsView, NewsDetailsPresenter>(), NewsDetailsView {
    companion object {
        const val KEY_ITEM_ID = "key_tab_num"
        private const val NO_CONTENT = -1L
        private const val KEY_ARTICLE = "key_article"
    }


    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.activity_news_details
    }
}