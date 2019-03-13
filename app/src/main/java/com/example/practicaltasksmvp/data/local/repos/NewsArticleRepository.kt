package com.example.practicaltasksmvp.data.local.repos

import com.example.practicaltasksmvp.data.local.realm.entity.NewsArticle
import io.reactivex.Observable
import io.realm.RealmResults

interface NewsArticleRepository {
    fun getArticlesByCategoryId(categoryId: Long): Observable<List<NewsArticle>>
}