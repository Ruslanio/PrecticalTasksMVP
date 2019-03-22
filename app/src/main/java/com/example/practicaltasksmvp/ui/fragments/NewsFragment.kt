package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.presenter.fragment.NewsPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.NewsView
import com.example.practicaltasksmvp.util.gone
import com.example.practicaltasksmvp.util.setUp
import com.example.practicaltasksmvp.util.visible
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.android.synthetic.main.item_news_article.view.*
import javax.inject.Inject

class NewsFragment : BaseFragment<NewsView, NewsPresenter>(), NewsView {


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

    @ProvidePresenter
    override fun providePresenter(): NewsPresenter = daggerPresenter.get()

    @InjectPresenter
    override lateinit var presenter: NewsPresenter

    @Inject
    override lateinit var daggerPresenter: Lazy<NewsPresenter>

    override fun onInit(savedInstanceState: Bundle?) {
        val categoryId = arguments?.getLong(KEY_CATEGORY_ID)
        val screenName = arguments?.getString(KEY_SCREEN_NAME)

        tvNewsScreenName.text = screenName
        presenter.getArticlesByCategoryId(categoryId!!, true)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_news
    }

    override fun showArticles(articles: List<NewsArticleEntity>) {
        view?.rvNews?.setUp(articles as MutableList<NewsArticleEntity>, R.layout.item_news_article, {
            ivNewsImage.setImageResource(it.imageId)
            tvNewsName.text = it.name
            tvNewsDescription.text = it.shortDescription
            tvNewsTimePeriod.text = it.timePeriod
        }, itemClick = { presenter.onNewsClick(this) })

    }

    override fun onProgressStart() {
        pgNewsList.visible()
        rvNews.gone()
    }

    override fun onProgressStop() {
        pgNewsList.gone()
        rvNews.visible()
    }
}