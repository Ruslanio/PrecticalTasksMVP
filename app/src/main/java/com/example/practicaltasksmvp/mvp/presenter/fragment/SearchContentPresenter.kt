package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasks.util.rxbus.RxBus
import com.example.practicaltasks.util.rxbus.RxBusEvents
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.SearchContentView
import io.reactivex.disposables.Disposable
import java.util.*

@InjectViewState
class SearchContentPresenter() : BasePresenter<SearchContentView>() {

    companion object {
        const val TEST_RESULTS_NUM = 4
    }

    private lateinit var onFragmentVisibleDisposable: Disposable

    private val testData = ArrayList<String>()

    private fun getRandom(count: Int): List<String> {
        if (count > testData.size) {
            throw IllegalArgumentException("Count can't be greater than list size")
        }
        testData.shuffle()
        return testData.take(count)
    }

    fun prepareTestData(tabNum: Int?, count: Int = TEST_RESULTS_NUM) {
        testData.add("Благотворительный фонд Алины")
        testData.add("\"Во имя жизни\"")
        testData.add("Благотворительный фонд Потанина")
        testData.add("\"Детские домики\"")
        testData.add("\"Мозаика счастья\"")
        testData.add("\"Правое дело\"")
        testData.add("\"Баржа Любви\"")
        testData.add("\"Собаке собачья любовь\"")

        viewState.showData(getRandom(count))

        onFragmentVisibleDisposable = RxBus.listen(RxBusEvents.EventViewPagerOnFragmentVisible::class.java).subscribe {
            if (it.tabNum == tabNum) {
                testData.shuffle()
                viewState.showData(getRandom(count))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!onFragmentVisibleDisposable.isDisposed) {
            onFragmentVisibleDisposable.dispose()
        }
    }
}