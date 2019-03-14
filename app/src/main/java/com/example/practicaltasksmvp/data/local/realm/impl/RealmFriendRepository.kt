package com.example.practicaltasksmvp.data.local.realm.impl

import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import com.example.practicaltasksmvp.data.local.realm.impl.base.AbstractRealmRepository
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