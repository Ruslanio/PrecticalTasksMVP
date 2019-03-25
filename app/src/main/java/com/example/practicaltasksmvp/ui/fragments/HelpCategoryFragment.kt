package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.presenter.fragment.HelpCategoryPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.HelpCategoryView
import com.example.practicaltasksmvp.util.gone
import com.example.practicaltasksmvp.util.setUp
import com.example.practicaltasksmvp.util.visible
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_help_categories.*
import kotlinx.android.synthetic.main.fragment_help_categories.view.*
import kotlinx.android.synthetic.main.item_help_category.view.*
import javax.inject.Inject

class HelpCategoryFragment : BaseFragment<HelpCategoryView, HelpCategoryPresenter>(), HelpCategoryView {

    companion object {

        private const val RV_COLUMN_COUNT = 2
    }

    @ProvidePresenter
    override fun providePresenter(): HelpCategoryPresenter = daggerPresenter.get()


    @InjectPresenter
    override lateinit var presenter: HelpCategoryPresenter

    @Inject
    override lateinit var daggerPresenter: Lazy<HelpCategoryPresenter>

    override fun onInit(savedInstanceState: Bundle?) {
        presenter.getCategories(true)
    }

    override fun showCategories(data: List<HelpCategoryEntity>?) {
        val categories = data as MutableList<HelpCategoryEntity>?
        if (categories != null)
            view?.rvCategories?.setUp(categories, R.layout.item_help_category, {
                tvCategory.text = it.name
                ivCategory.setImageResource(it.imageId)
            }, manager = GridLayoutManager(activity, RV_COLUMN_COUNT)
                , itemClick = {
                    presenter.openRelatedNews(this.name, this.id)
                })
    }

    override fun onProgressStart() {
        pgCategoriesList.visible()
        rvCategories.gone()
    }

    override fun onProgressStop() {
        pgCategoriesList.gone()
        rvCategories.visible()
    }


    override fun layoutId(): Int {
        return R.layout.fragment_help_categories
    }
}