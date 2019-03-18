package com.example.practicaltasksmvp.util.adapter

import android.view.View

class Kadapter<in ITEM>(private val items: MutableList<ITEM>, layoutResId: Int,
                        private val bindHolder: View.(ITEM) -> Unit,
                        private val itemClick: ITEM.() -> Unit = {})
    : AbstractAdapter<ITEM>(items, layoutResId) {

    override fun onItemClick(itemView: View, position: Int) {
        items[position].itemClick()
    }

    override fun View.bind(item: ITEM) {
        bindHolder(item)
    }
}