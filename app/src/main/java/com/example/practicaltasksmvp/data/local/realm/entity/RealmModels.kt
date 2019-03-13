package com.example.practicaltasksmvp.data.local.realm.entity

import androidx.annotation.DrawableRes
import com.example.practicaltasksmvp.R
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*


@RealmClass
open class HelpCategory : RealmObject() {


    @PrimaryKey
    var id: Long = 0

    var name: String = ""

    var type: String = ""

    @Ignore
    internal var articles: List<NewsArticle> = Collections.emptyList()

    @DrawableRes
    var imageId: Int = R.drawable.placeholder
}

@RealmClass
open class NewsArticle : RealmObject() {

    @PrimaryKey
    var id: Long = 0

    var name: String = ""

    var shortDescription: String = ""

    var description: String = ""

    var dateFrom: String = ""

    var dateTo: String = ""

    @Ignore
    internal var phoneNumbers: List<Phone> = Collections.emptyList()

    var type: String = ""

    var address: String = ""

    var orgName: String = ""

    var orgSite: String = ""

    @Ignore
    internal var likedFriends: List<Friend> = Collections.emptyList()

    var category: HelpCategory? = null

    @DrawableRes
    var imageId: Int = R.drawable.placeholder

    var timePeriod: String? = null
}

@RealmClass
open class Phone : RealmObject() {

    @PrimaryKey
    var id: Long = 0

    var number: String = ""

    var articles: RealmList<NewsArticle>? = null

}

@RealmClass
open class Friend : RealmObject() {

    @PrimaryKey
    var id: Long = 0

    var firstName: String = ""

    var secondName: String = ""

    @DrawableRes
    var avatarIconRes: Int = R.drawable.placeholder

    var articles: RealmList<NewsArticle>? = null
}