package com.example.practicaltasksmvp.data.remote

import com.example.practicaltasksmvp.data.remote.pojo.HelpCategoryPojo
import com.example.practicaltasksmvp.util.defaultSchedulers
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {
        private const val BASE_URL = "https://practicaltasks-55335.firebaseio.com"
        private const val DEFAULT_TITLE = "main"
        private const val AUTH_KEY = "BrJ1YL6g0pmVwfQFmAoQjG5ursGnbC5OrFzXLrN4"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    fun getData(title: String = DEFAULT_TITLE): Single<List<HelpCategoryPojo>> {
        return apiService
            .getData(title, AUTH_KEY)
            .defaultSchedulers()
    }
}