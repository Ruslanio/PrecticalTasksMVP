package com.example.practicaltasksmvp.navigation

import android.content.Context
import android.content.Intent
import com.example.practicaltasksmvp.ui.activities.MainActivity
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