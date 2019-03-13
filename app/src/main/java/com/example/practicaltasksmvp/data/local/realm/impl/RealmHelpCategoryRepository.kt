package com.example.practicaltasks.data.local.repositories.realm

import com.example.practicaltasksmvp.data.local.realm.entity.HelpCategory
import io.realm.RealmConfiguration

class RealmHelpCategoryRepository(config: RealmConfiguration) : AbstractRealmRepository<HelpCategory>(config) {
    override fun entityClass(): Class<HelpCategory> {
        return HelpCategory::class.java
    }

}