package com.example.practicaltasks.data.local.repositories.realm

import com.example.practicaltasksmvp.data.local.realm.entity.NewsArticle
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RealmNewsArticleRepository(config: RealmConfiguration) : AbstractRealmRepository<NewsArticle>(config) {

    override fun entityClass(): Class<NewsArticle> {
        return NewsArticle::class.java
    }

    fun getArticlesByCategoryId(categoryId: Long): RealmResults<NewsArticle> {
        return getRealm().where(NewsArticle::class.java).equalTo("category.id", categoryId).findAll()
    }
}