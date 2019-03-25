package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchContentPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchContentView
import com.example.practicaltasksmvp.util.setUp
import com.example.practicaltasksmvp.util.updateList
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_search_content.view.*
import kotlinx.android.synthetic.main.item_search_result.view.*
import java.util.*
import javax.inject.Inject

class SearchContentFragment : BaseFragment<SearchContentView, SearchContentPresenter>(), SearchContentView {
    companion object {

        const val KEY_TAB_NUM = "key_tab_num"
        fun newInstance(tabNum: Int): Fragment {
            val fragment = SearchContentFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_TAB_NUM, tabNum)
            fragment.arguments = bundle
            return fragment
        }

    }


    @ProvidePresenter
    override fun providePresenter(): SearchContentPresenter = daggerPresenter.get()

    @InjectPresenter
    override lateinit var presenter: SearchContentPresenter

    @Inject
    override lateinit var daggerPresenter: Lazy<SearchContentPresenter>

    override fun onInit(savedInstanceState: Bundle?) {
        view?.rvResults?.setUp(
            Collections.emptyList<String>(),
            R.layout.item_search_result,
            { tvResultName.text = it })

        val tabNum = arguments?.getInt(KEY_TAB_NUM)
        presenter.prepareTestData(tabNum)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_search_content
    }

    override fun showData(data: List<String>) {
        view?.rvResults?.updateList(data)
    }


}