package com.example.practicaltasksmvp.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.practicaltasksmvp.data.local.DbManager.Companion.EVERY_CATEGORY
import com.example.practicaltasksmvp.ui.activities.MainActivity
import com.example.practicaltasksmvp.ui.activities.NewsDetailsActivity
import com.example.practicaltasksmvp.ui.activities.NewsDetailsActivity.Companion.KEY_ITEM_ID
import com.example.practicaltasksmvp.ui.fragments.*
import ru.terrakok.cicerone.android.support.SupportAppScreen

const val SCREEN_HELP_CATEGORIES = "screen_help_categories"
const val SCREEN_PROFILE = "screen_profile"
const val SCREEN_SEARCH = "screen_search"
const val SCREEN_HISTORY = "screnn_history"
const val SCREEN_NEWS = "screen_news"


class MainScreen : SupportAppScreen() {
    override fun getActivityIntent(context: Context?): Intent {
        return Intent(context, MainActivity::class.java)
    }
}

class HelpCategoriesScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return HelpCategoryFragment()
    }
}

class ProfileScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return ProfileFragment()
    }
}


class SearchScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SearchFragment()
    }
}

class NewsScreen(private val screenName: String, private val categoryId: Long = EVERY_CATEGORY) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return NewsFragment.newInstance(screenName, categoryId)
    }
}

class NewsDetailsScreen(private val itemId: Long) : SupportAppScreen() {
    override fun getActivityIntent(context: Context?): Intent {
        val intent = Intent(context, NewsDetailsActivity::class.java)
        intent.putExtra(KEY_ITEM_ID, itemId)
        return intent
    }
}

class SearchContentScreen(private val tabNum: Int) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SearchContentFragment.newInstance(tabNum)
    }
}