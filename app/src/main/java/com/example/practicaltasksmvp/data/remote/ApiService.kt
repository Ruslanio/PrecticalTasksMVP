package com.example.practicaltasksmvp.data.remote

import com.example.practicaltasksmvp.data.remote.pojo.HelpCategoryPojo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ApiService {

    @GET("/data/{title}.json")
    fun getData(@Path("title") title: String, @Query("auth") authKey : String): Single<List<HelpCategoryPojo>>
}