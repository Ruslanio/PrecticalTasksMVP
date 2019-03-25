package com.example.practicaltasksmvp.util.adapter.pager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.practicaltasksmvp.ui.fragments.SearchContentFragment

class SearchPagerAdapter(
    manager: FragmentManager,
    private val byEventsTabName: String,
    private val byNkoTabName: String
) : FragmentPagerAdapter(manager) {
    companion object {
        const val BY_EVENTS = 0
        const val BY_NKO = 1

        const val FRAGMENTS_COUNT = 2
    }

    override fun getItem(position: Int): Fragment {
        return SearchContentFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return FRAGMENTS_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            BY_EVENTS -> byEventsTabName
            BY_NKO -> byNkoTabName
            else -> byNkoTabName
        }
    }
}