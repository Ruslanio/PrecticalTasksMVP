package com.example.practicaltasks.data.local.repositories.realm

import com.example.practicaltasksmvp.data.local.realm.BaseContract
import com.example.practicaltasksmvp.data.local.Repository
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.RealmResults

abstract class AbstractRealmRepository<T : RealmObject>(private val config: RealmConfiguration) :
    Repository<T> {

    override fun add(obj: T) {
        Realm.getInstance(config).executeTransaction {
            it.insertOrUpdate(obj)
        }
    }

    override fun addAll(objects: List<T>) {
        Realm.getInstance(config).executeTransaction {
            it.insertOrUpdate(objects)
        }
    }

    override fun getById(id: Long): T? {
        return Realm.getInstance(config).where(entityClass()).equalTo(BaseContract.ID, id).findFirst()
    }

    override fun getAll(): RealmResults<T> {
        return Realm.getInstance(config).where(entityClass()).findAll() as RealmResults<T>
    }

    abstract fun entityClass() : Class<T>

    fun getRealm() : Realm{
        return Realm.getInstance(config)
    }
}