package com.example.practicaltasksmvp.util

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.practicaltasksmvp.util.adapter.Kadapter
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.defaultSchedulers(): Observable<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.defaultSchedulers(): Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}


fun <I> androidx.recyclerview.widget.RecyclerView.setUp(items: MutableList<I>,
                                                        layoutResId: Int,
                                                        bindHolder: View.(I) -> Unit,
                                                        itemClick: I.() -> Unit = {},
                                                        manager: androidx.recyclerview.widget.RecyclerView.LayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this.context)): Kadapter<I> {
    layoutManager = manager
    return Kadapter(items, layoutResId, bindHolder, itemClick).apply { adapter = this }

}

fun <I> androidx.recyclerview.widget.RecyclerView.updateList(items: List<I>) {
    (adapter as Kadapter<I>).update(items)
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun SwipeRefreshLayout.startRefresh(){
    isRefreshing = true
}


fun SwipeRefreshLayout.stopRefresh(){
    isRefreshing = false
}