package com.example.practicaltasksmvp.data.mappers

import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import com.example.practicaltasksmvp.data.local.realm.entity.HelpCategory
import com.example.practicaltasksmvp.data.local.realm.entity.NewsArticle
import com.example.practicaltasksmvp.data.local.realm.entity.Phone
import com.example.practicaltasksmvp.mvp.model.FriendEntity
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import com.example.practicaltasksmvp.mvp.model.PhoneEntity


fun mapToEntity(helpCategory: HelpCategory?): HelpCategoryEntity {
    if (helpCategory != null) {
        return with(helpCategory) {
            val res = HelpCategoryEntity()
            res.id = id
            res.imageId = imageId
            res.name = name
            res.type = type
            return@with res
        }
    } else {
        return HelpCategoryEntity()
    }
}

fun mapToEntity(newsArticle: NewsArticle?): NewsArticleEntity {
    if (newsArticle != null) {
        return with(newsArticle) {
            val res = NewsArticleEntity()
            res.id = id
            res.address = address
            res.description = description
            res.imageId = imageId
            res.name = name
            res.orgName = orgName
            res.orgSite = orgSite
            res.timePeriod = timePeriod
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

fun mapToEntity(friend: Friend?): FriendEntity {
    if (friend != null) {
        return with(friend) {
            val res = FriendEntity()
            res.avatarIconRes = avatarIconRes
            res.firstName = firstName
            res.secondName = secondName
            return@with res
        }
    } else {
        return FriendEntity()
    }
}

fun mapToEntity(phone: Phone?): PhoneEntity {
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