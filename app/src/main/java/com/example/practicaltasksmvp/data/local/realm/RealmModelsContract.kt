package com.example.practicaltasksmvp.data.local.realm


class HelpCategoryContract : BaseContract() {
    companion object {
        const val NAME = "name"
        const val TYPE = "type"
        val article = NewsArticleContract()
    }
}

class NewsArticleContract : BaseContract() {
    companion object {
        const val NAME = "name"
        const val SHORT_DESCRIPTION = "shortDescription"
        const val DESCRIPTION = "description"
        const val DATE_FROM = "dateFrom"
        const val DATE_TO = "dateTo"
        const val TYPE = "type"
        const val ADDRESS = "address"
        const val ORG_NAME = "orgName"
        const val ORG_SITE = "orgSite"
        const val TIME_PERIOD = "timePeriod"
        val phone = PhoneContract()
        val friend = FriendContract()
    }
}

class PhoneContract : BaseContract() {
    companion object {
        const val NUMBER = "number"
    }
}

class FriendContract : BaseContract() {
    companion object {
        const val FIRST_NAME = "firstName"
        const val SECOND_NAME = "secondName"
    }
}

open class BaseContract {
    companion object {
        const val ID = "id"
    }
}