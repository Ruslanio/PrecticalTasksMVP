package com.example.practicaltasksmvp.data.local.realm.async.executors

import android.os.Handler
import android.os.Message

class ExecutionHandler<T>(private val receiver: (result: T) -> Unit, private val starter: () -> Unit) : Handler() {
    companion object {
        const val MSG_ON_LOAD_START = 0
        const val MSG_ON_RECEIVE = 1

    }

    override fun handleMessage(msg: Message?) {
        when (msg?.what) {
            MSG_ON_LOAD_START -> handleStart()
            MSG_ON_RECEIVE -> handleReceive(msg.obj)
        }
    }

    private fun handleReceive(obj: Any) {
        try {
            receiver(obj as T)
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    private fun handleStart() {
        starter()
    }
}