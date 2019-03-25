package com.example.practicaltasksmvp.mvp.presenter.activity

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.activity.MainView
import com.example.practicaltasksmvp.navigation.*
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(private val router: Router, private val defaultScreenName : String) : BasePresenter<MainView>() {
    
    
    fun navigateTo (screenName: String) {
        when (screenName) {
            SCREEN_HELP_CATEGORIES -> router.replaceScreen(HelpCategoriesScreen())
            SCREEN_PROFILE -> router.replaceScreen(ProfileScreen())
            SCREEN_HISTORY -> router.replaceScreen(HelpCategoriesScreen())
            SCREEN_SEARCH -> router.replaceScreen(SearchScreen())
            SCREEN_NEWS -> {
                router.replaceScreen(NewsScreen(defaultScreenName))
            }
        }
        
    }
}