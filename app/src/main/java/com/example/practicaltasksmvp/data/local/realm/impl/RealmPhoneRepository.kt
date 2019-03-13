package com.example.practicaltasks.data.local.repositories.realm

import com.example.practicaltasksmvp.data.local.realm.entity.Phone
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