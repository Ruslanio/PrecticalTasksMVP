package com.example.practicaltasksmvp.data.remote.pojo

import com.google.gson.annotations.SerializedName

data class HelpCategoryPojo(
        val articles: List<ArticlePojo>,
        @SerializedName("category_name")
        val name: String,
        @SerializedName("category_type")
        val type: String,
        val id: Int
)

data class ArticlePojo(
        val address: String,
        @SerializedName("date_from")
        val dateFrom: String,
        @SerializedName("date_to")
        val dateTo: String,
        val description: String,
        val id: Int,
        @SerializedName("liked_friends")
        val likedFriends: List<LikedFriendPojo>,
        val name: String,
        @SerializedName("org_name")
        val orgName: String,
        @SerializedName("org_site")
        val orgSite: String,
        @SerializedName("phone_numbers")
        val phoneNumbers: List<PhoneNumberPojo>,
        @SerializedName("short_description")
        val shortDescription: String,
        val type: String
)

data class PhoneNumberPojo(
        val id: Int,
        val number: String
)

data class LikedFriendPojo(
        @SerializedName("first_name")
        val firstName: String,
        val id: Int,
        @SerializedName("second_name")
        val secondName: String
)