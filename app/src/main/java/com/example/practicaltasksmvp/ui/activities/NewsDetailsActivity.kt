package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.model.FriendEntity
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.presenter.activity.NewsDetailsPresenter
import com.example.practicaltasksmvp.mvp.view.activity.NewsDetailsView
import com.example.practicaltasksmvp.util.gone
import com.example.practicaltasksmvp.util.setUp
import com.example.practicaltasksmvp.util.visible
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.item_liked_friend.view.*
import javax.inject.Inject

class NewsDetailsActivity : BaseActivity<NewsDetailsView, NewsDetailsPresenter>(), NewsDetailsView {
    companion object {

        const val KEY_ITEM_ID = "key_tab_num"

        private const val NO_CONTENT = -1L
        private const val KEY_ARTICLE = "key_article"
    }

    private var newsId: Long = NO_CONTENT

    private var newsArticle: NewsArticleEntity? = null

    @Inject
    override lateinit var daggerPresenter: Lazy<NewsDetailsPresenter>

    @ProvidePresenter
    override fun providePresenter(): NewsDetailsPresenter = daggerPresenter.get()

    @InjectPresenter
    override lateinit var presenter: NewsDetailsPresenter

    override fun onInit(savedInstanceState: Bundle?) {
        newsId = intent?.getLongExtra(KEY_ITEM_ID, NO_CONTENT) ?: NO_CONTENT
        newsArticle = savedInstanceState?.getSerializable(KEY_ARTICLE) as NewsArticleEntity?
        showArticle(newsArticle)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY_ARTICLE, newsArticle)
        super.onSaveInstanceState(outState)
    }

    override fun layoutId(): Int {
        return R.layout.activity_news_details
    }

    override fun showArticle(newsArticle: NewsArticleEntity?) {
        if (newsArticle != null) {
            with(newsArticle) {
                tvAddress.text = address
                tvNewsName.text = name
                tvOrgName.text = orgName
                tvPhoneNumber.text = presenter.printNumbers(phoneNumbers)
                tvNewsDescription.text = description
                tvNewsTimePeriod.text = timePeriod
                ivMainImg.setImageResource(imageId)

                rvLikedFriends.setUp(likedFriends as MutableList<FriendEntity>, R.layout.item_liked_friend, {
                    ivAvatar.setImageResource(it.avatarIconRes)
                }, manager = LinearLayoutManager(this@NewsDetailsActivity, LinearLayoutManager.HORIZONTAL, false))


            }
        } else {
            presenter.getArticle(true, newsId)
        }
        tvArticleName.isSelected = true
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolBar.setNavigationOnClickListener {
            presenter.close()
        }
    }

    override fun onProgressStart() {
        pgNewsDetails.visible()
        nsMain.gone()
    }

    override fun onProgressStop() {
        pgNewsDetails.gone()
        nsMain.visible()
    }

    override fun finishView() {
        finish()
    }
}
