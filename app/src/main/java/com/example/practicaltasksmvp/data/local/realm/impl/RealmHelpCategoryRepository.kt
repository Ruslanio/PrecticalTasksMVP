package com.example.practicaltasksmvp.data.local.realm.impl

import com.example.practicaltasksmvp.data.local.realm.entity.HelpCategory
import com.example.practicaltasksmvp.data.local.realm.impl.base.AbstractRealmRepository
import io.realm.RealmConfiguration

class RealmHelpCategoryRepository(config: RealmConfiguration) : AbstractRealmRepository<HelpCategory>(config) {
    override fun entityClass(): Class<HelpCategory> {
        return HelpCategory::class.java
    }

}