package com.example.practicaltasks.util.rxbus

import androidx.annotation.IdRes

class RxBusEvents {
    data class EventViewPagerOnFragmentVisible(val tabNum: Int)
    data class EventEditDialogOnButtonClick(@IdRes val btnId: Int?)
}