package com.example.practicaltasksmvp.data.local.realm.async.executors

import android.os.Message

class HandlingExecutionCallback<T>(onResult : (result : T) -> Unit, onStart : () -> Unit = {})
    : ExecutionCallback<T> {

    private val handler = ExecutionHandler<T>(onResult,onStart)

    override fun onExecutionComplete(result: T) {
        val msg = Message()
        msg.obj = result
        msg.what = ExecutionHandler.MSG_ON_RECEIVE
        handler.sendMessage(msg)
    }

    override fun onExecutionStart() {
        val msg = Message()
        msg.what = ExecutionHandler.MSG_ON_LOAD_START
        handler.sendMessage(msg)

    }
}