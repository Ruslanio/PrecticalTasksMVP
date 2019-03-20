package com.example.practicaltasksmvp.data.mappers

import android.content.Context
import com.example.practicaltasksmvp.data.remote.pojo.ArticlePojo
import com.example.practicaltasksmvp.data.remote.pojo.HelpCategoryPojo
import com.example.practicaltasksmvp.data.remote.pojo.LikedFriendPojo
import com.example.practicaltasksmvp.data.remote.pojo.PhoneNumberPojo
import com.example.practicaltasksmvp.mvp.model.FriendEntity
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.model.PhoneEntity
import com.example.practicaltasksmvp.util.createTimePeriod
import com.example.practicaltasksmvp.util.getArticleImage
import com.example.practicaltasksmvp.util.getCategoryImage
import com.example.practicaltasksmvp.util.getFriendAvatar

fun mapToEntity(helpCategory: HelpCategoryPojo?): HelpCategoryEntity {
    if (helpCategory != null) {
        return with(helpCategory) {
            val res = HelpCategoryEntity()
            res.id = id.toLong()
            res.imageId = getCategoryImage(type)
            res.name = name
            res.type = type
            return@with res
        }
    } else {
        return HelpCategoryEntity()
    }
}

fun mapToEntity(context: Context, newsArticle: ArticlePojo?): NewsArticleEntity {
    if (newsArticle != null) {
        return with(newsArticle) {
            val res = NewsArticleEntity()
            res.id = id.toLong()
            res.address = address
            res.description = description
            res.imageId = getArticleImage(id.toLong())
            res.name = name
            res.orgName = orgName
            res.orgSite = orgSite
            res.timePeriod = createTimePeriod(context, type, dateFrom, dateTo)
            res.shortDescription = shortDescription
            res.type = type
            res.likedFriends = likedFriends.map(::mapToEntity)
            res.phoneNumbers = phoneNumbers.map(::mapToEntity)
            return@with res
        }
    } else {
        return NewsArticleEntity()
    }
}

fun mapToEntity(friend: LikedFriendPojo?): FriendEntity {
    if (friend != null) {
        return with(friend) {
            val res = FriendEntity()
            res.avatarIconRes = getFriendAvatar(id.toLong())
            res.firstName = firstName
            res.secondName = secondName
            return@with res
        }
    } else {
        return FriendEntity()
    }
}

fun mapToEntity(phone: PhoneNumberPojo?): PhoneEntity {
    if (phone != null) {
        return with(phone) {
            val res = PhoneEntity()
            res.number = number
            return@with res
        }
    } else {
        return PhoneEntity()
    }
}