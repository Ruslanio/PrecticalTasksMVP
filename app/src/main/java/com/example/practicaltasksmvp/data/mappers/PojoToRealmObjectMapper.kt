package com.example.practicaltasksmvp.data.mappers

import android.content.Context

import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import com.example.practicaltasksmvp.data.local.realm.entity.HelpCategory
import com.example.practicaltasksmvp.data.local.realm.entity.NewsArticle
import com.example.practicaltasksmvp.data.local.realm.entity.Phone
import com.example.practicaltasksmvp.data.remote.pojo.ArticlePojo
import com.example.practicaltasksmvp.data.remote.pojo.HelpCategoryPojo
import com.example.practicaltasksmvp.data.remote.pojo.LikedFriendPojo
import com.example.practicaltasksmvp.data.remote.pojo.PhoneNumberPojo
import com.example.practicaltasksmvp.util.*
import io.realm.RealmList
import io.realm.RealmObject

private fun mapToHelpCategory(jsonObject: HelpCategoryPojo): HelpCategory {
    val result = HelpCategory()
    with(result) {
        id = jsonObject.id.toLong()
        name = jsonObject.name
        type = jsonObject.type
        imageId = getCategoryImage(type)
    }
    return result
}

private fun mapToNewsArticle(context: Context, jsonObject: ArticlePojo, parent: RealmObject): NewsArticle {
    val result = NewsArticle()
    with(result) {
        id = jsonObject.id.toLong()
        name = jsonObject.name
        address = jsonObject.address
        orgName = jsonObject.orgName
        orgSite = jsonObject.orgSite
        type = jsonObject.type
        dateFrom = jsonObject.dateFrom
        dateTo = jsonObject.dateTo
        shortDescription = jsonObject.shortDescription
        description = jsonObject.description
        imageId = getArticleImage(id)
        timePeriod = createTimePeriod(context, type, dateFrom, dateTo)
        category = parent as HelpCategory
    }
    return result
}

private fun mapToPhone(jsonObject: PhoneNumberPojo, parent: RealmObject): Phone {
    val result = Phone()
    with(result) {
        id = jsonObject.id.toLong()
        number = jsonObject.number
        val articleRealmList = RealmList<NewsArticle>()
        articleRealmList.addAll(listOf(parent as NewsArticle))
        articles = articleRealmList
    }
    return result
}

private fun mapToFriend(jsonObject: LikedFriendPojo, parent: RealmObject): Friend {
    val result = Friend()
    with(result) {
        id = jsonObject.id.toLong()
        firstName = jsonObject.firstName
        secondName = jsonObject.secondName
        avatarIconRes = getFriendAvatar(id)
        val articleRealmList = RealmList<NewsArticle>()
        articleRealmList.addAll(listOf(parent as NewsArticle))
        articles = articleRealmList

    }
    return result
}


fun mapPojoData(context: Context, categories: List<HelpCategoryPojo>): List<HelpCategory> {
    var categoryMapped: HelpCategory
    var articleMapped: NewsArticle
    var phoneMapped: Phone
    var friendMapped: Friend

    val categoriesRes = ArrayList<HelpCategory>()
    val articlesRes = ArrayList<NewsArticle>()
    val friendsRes = ArrayList<Friend>()
    val phonesRes = ArrayList<Phone>()

    for (category in categories) {
        categoryMapped = mapToHelpCategory(category)
        for (article in category.articles) {
            articleMapped = mapToNewsArticle(context, article, categoryMapped)
            for (friend in article.likedFriends) {
                friendMapped = mapToFriend(friend, articleMapped)
                friendsRes.add(friendMapped)
            }
            for (phone in article.phoneNumbers) {
                phoneMapped = mapToPhone(phone, articleMapped)
                phonesRes.add(phoneMapped)
            }
            articleMapped.likedFriends = friendsRes.toMutableList()
            articleMapped.phoneNumbers = phonesRes.toMutableList()
            articlesRes.add(articleMapped)

            friendsRes.clear()
            phonesRes.clear()
        }
        categoryMapped.articles = articlesRes.toMutableList()
        categoriesRes.add(categoryMapped)

        articlesRes.clear()
    }
    return categoriesRes

}