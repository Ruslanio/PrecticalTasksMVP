package com.example.practicaltasksmvp.data.local.repos

import com.example.practicaltasksmvp.data.local.realm.entity.Phone
import io.reactivex.Observable
import io.realm.RealmResults

interface PhoneRepository {
    fun getByArticleId(articleId: Long): Observable<List<Phone>>
}