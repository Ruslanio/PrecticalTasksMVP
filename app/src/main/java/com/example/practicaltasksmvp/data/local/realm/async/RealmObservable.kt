package com.example.practicaltasksmvp.data.local.realm.async

import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmConfiguration
import java.lang.Exception

class RealmObservable {

    companion object {
        const val CONFIG_IS_NULL_MESSAGE = "config can not be null!"

        fun <T> asObservable(
            asyncAction: (realm: Realm) -> T,
            config: RealmConfiguration? = Realm.getDefaultConfiguration()
        ): Observable<T> {
            if (config == null) {
                throw RealmObservableException(CONFIG_IS_NULL_MESSAGE)
            }
            return Observable.create {
                val realm = Realm.getInstance(config)
                try {
                    val result = asyncAction(realm)
                    it.onNext(result)
                    it.onComplete()

                } catch (e: Exception) {
                    e.printStackTrace()
                    it.onError(RealmObservableException(e.message!!))
                } finally {
                    realm.close()
                }
            }
        }
    }
}