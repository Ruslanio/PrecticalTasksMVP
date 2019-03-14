package com.example.practicaltasksmvp.data.local.realm.impl

import com.example.practicaltasksmvp.data.local.realm.entity.Phone
import com.example.practicaltasksmvp.data.local.realm.impl.base.AbstractRealmRepository
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RealmPhoneRepository(config: RealmConfiguration) : AbstractRealmRepository<Phone>(config) {
    override fun entityClass(): Class<Phone> {
        return Phone::class.java
    }


    fun getByArticleId(articleId: Long): RealmResults<Phone> {
        return getRealm().where(Phone::class.java).equalTo("articles.id", articleId).findAll()
    }

}