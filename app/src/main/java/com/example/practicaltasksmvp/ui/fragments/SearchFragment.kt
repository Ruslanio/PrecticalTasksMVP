package com.example.practicaltasksmvp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.SearchPresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchView
import com.example.practicaltasksmvp.util.adapter.pager.SearchPagerAdapter
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView, HasSupportFragmentInjector {
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    override lateinit var daggerPresenter: Lazy<SearchPresenter>

    @InjectPresenter
    override lateinit var presenter: SearchPresenter

    @ProvidePresenter
    override fun providePresenter(): SearchPresenter = daggerPresenter.get()

    override fun onInit(savedInstanceState: Bundle?) {
        val eventTab = resources.getString(R.string.by_events)
        val nkoTab = resources.getString(R.string.by_nko)
        val pagerAdapter = SearchPagerAdapter(childFragmentManager, eventTab, nkoTab)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {}

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(position: Int) {
                presenter.publish(position)
            }
        })
        pager.adapter = pagerAdapter
        view?.tabLayout?.setupWithViewPager(pager)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_search
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pager.clearOnPageChangeListeners()
    }
}