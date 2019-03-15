package com.example.practicaltasksmvp.ui.activities

import android.os.Bundle
import android.widget.Toast
import com.example.practicaltasks.views.bottomBar.CustomBottomView
import com.example.practicaltasks.views.bottomBar.SpaceItem
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseActivity
import com.example.practicaltasksmvp.mvp.presenter.activity.MainPresenter
import com.example.practicaltasksmvp.mvp.view.MainView
import com.example.practicaltasksmvp.navigation.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onInit(savedInstanceState: Bundle?) {
        bottomView.addSpaceItem(SpaceItem(resources.getString(R.string.news), R.drawable.ic_news, SCREEN_NEWS))
        bottomView.addSpaceItem(SpaceItem(resources.getString(R.string.search), R.drawable.ic_search, SCREEN_SEARCH))
        bottomView.addSpaceItem(SpaceItem(resources.getString(R.string.history), R.drawable.ic_history, SCREEN_HISTORY))
        bottomView.addSpaceItem(SpaceItem(resources.getString(R.string.profile), R.drawable.ic_profile, SCREEN_PROFILE))

        bottomView.onClickBottomViewListener = object : CustomBottomView.OnClickListener {
            override fun onCentreButtonClick() {

            }

            override fun onItemClick(itemIndex: Int, itemName: String, screenName: String) {

            }

            override fun onItemReselected(itemIndex: Int, itemName: String) {
                Toast.makeText(this@MainActivity, "ITEM NAME - $itemName RESELECTED", Toast.LENGTH_SHORT).show()
            }
        }
        if (savedInstanceState == null) {
            bottomView.setCurrentItem(SCREEN_NEWS)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }


}
