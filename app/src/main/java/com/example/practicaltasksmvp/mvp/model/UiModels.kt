package com.example.practicaltasksmvp.mvp.model

import androidx.annotation.DrawableRes
import com.example.practicaltasksmvp.R
import java.io.Serializable
import java.util.*


open class FriendEntity : Serializable {

    var firstName: String = ""

    var secondName: String = ""

    @DrawableRes
    var avatarIconRes: Int = R.drawable.placeholder

}


open class HelpCategoryEntity : Serializable {

    var id: Long = 0

    var name: String = ""

    var type: String = ""

    @DrawableRes
    var imageId: Int = R.drawable.placeholder
}


open class NewsArticleEntity : Serializable {

    var id: Long = 0

    var name: String = ""

    var shortDescription: String = ""

    var description: String = ""

    var type: String = ""

    var address: String = ""

    var orgName: String = ""

    var orgSite: String = ""

    @DrawableRes
    var imageId: Int = R.drawable.placeholder

    var timePeriod: String? = null

    var phoneNumbers: List<PhoneEntity> = Collections.emptyList()

    var likedFriends: List<FriendEntity> = Collections.emptyList()

}


open class PhoneEntity : Serializable {

    var number: String = ""
}
