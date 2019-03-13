package com.example.practicaltasksmvp.data.local.realm.impl

import com.example.practicaltasks.data.local.repositories.realm.AbstractRealmRepository
import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RealmFriendRepository(config: RealmConfiguration) : AbstractRealmRepository<Friend>(config) {
    override fun entityClass(): Class<Friend> {
        return Friend::class.java
    }


    fun getByArticleId(articleId: Long) :RealmResults<Friend> {
        return getRealm().where(Friend::class.java).equalTo("articles.id",articleId).findAll()
    }

}