package com.example.practicaltasksmvp.data.local.realm.async

import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmObservable {

    companion object {
        private const val CONFIG_IS_NULL_MESSAGE = "config can not be null!"

        fun <T> asReadSingle(
            asyncAction: (realm: Realm) -> T,
            config: RealmConfiguration? = Realm.getDefaultConfiguration()
        ): Single<T> {
            if (config == null) {
                throw RealmObservableException(CONFIG_IS_NULL_MESSAGE)
            }
            return Single.create { emitter ->
                try {
                    Realm.getInstance(config).use {
                        val result = asyncAction(it)
                        emitter.onSuccess(result)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(RealmObservableException(e.message!!))
                }
            }
        }

        fun <T> asInsertCompletable(
            asyncAction: (realm: Realm) -> Unit,
            config: RealmConfiguration? = Realm.getDefaultConfiguration()
        ): Completable {
            if (config == null) {
                throw RealmObservableException(CONFIG_IS_NULL_MESSAGE)
            }
            return Completable.create { emitter ->
                try {
                    Realm.getInstance(config).use {
                        asyncAction(it)
                        emitter.onComplete()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(RealmObservableException(e.message!!))
                }
            }
        }
    }
}