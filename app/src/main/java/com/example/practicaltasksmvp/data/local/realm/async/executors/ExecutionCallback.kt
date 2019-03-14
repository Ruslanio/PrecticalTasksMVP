package com.example.practicaltasksmvp.data.local.realm.async.executors

interface ExecutionCallback<T> {
    fun onExecutionStart()
    fun onExecutionComplete(result: T)
}