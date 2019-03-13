package com.example.practicaltasksmvp.data.local.repos

import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import io.reactivex.Observable
import io.realm.RealmResults

interface FriendRepository {
    fun getByArticleId(articleId: Long) : Observable<List<Friend>>
}