package com.example.practicaltasksmvp.data.local.realm.async.executors

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class ExecutorManager {

    private val executorService = Executors.newSingleThreadExecutor()

    fun doInBackground(job: () -> Unit): Future<*> {
        return executorService.submit { job() }
    }

    fun <T> doInBackgroundWithResult(job: () -> T): Future<T> {
        return executorService.submit(Callable<T> { job() })
    }

    fun <T> doInBackgroundWithResult(job: () -> T, executionCallback : ExecutionCallback<T>) {
        executorService.submit {
            executionCallback.onExecutionStart()
            val res = job()
            executionCallback.onExecutionComplete(res)
        }
    }

    fun destroy(){
        executorService.shutdown()
    }

}