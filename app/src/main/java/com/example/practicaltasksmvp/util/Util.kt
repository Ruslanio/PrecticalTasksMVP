package com.example.practicaltasksmvp.util

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.practicaltasksmvp.R
import org.threeten.bp.Instant
import org.threeten.bp.Period
import org.threeten.bp.ZoneId
import org.threeten.bp.format.TextStyle
import org.threeten.bp.temporal.ChronoUnit
import java.io.InvalidObjectException
import java.util.*

const val KID_IMAGE_RES = R.drawable.img
const val GUITAR_IMAGE_RES = R.drawable.img_2

fun createTimePeriod(context: Context, type: String, dateFrom: String, dateTo: String): String {
    when (type) {
        NewsType.SINGLE_DAY.type -> {
            val to = Instant.parse(dateTo).atZone(ZoneId.systemDefault()).toLocalDate()
            val toMonthName = to.month.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH)
            val toDay = to.dayOfMonth
            val toYear = to.year
            return "$toMonthName $toDay.$toYear"
        }
        NewsType.TIME_PERIOD.type -> {
            val today = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate()
            val from = Instant.parse(dateFrom).atZone(ZoneId.systemDefault()).toLocalDate()
            val to = Instant.parse(dateTo).atZone(ZoneId.systemDefault()).toLocalDate()
            val duration = Period.between(today, to)
            val durationInDays = duration.get(ChronoUnit.DAYS)
            val fromDay = from.dayOfMonth
            val fromMonth = from.month.value
            val toDay = to.dayOfMonth
            val toMonth = to.month.value
            val last = (duration.get(ChronoUnit.DAYS) % 10).toInt()
            val daysPlural = context.resources.getQuantityString(R.plurals.days_plural, last, durationInDays)
            return "$daysPlural (${fromDay}.${fromMonth} - ${toDay}.${toMonth})"
        }
        else -> throw InvalidObjectException("Unknown news type : $type")
    }
}

@DrawableRes
fun getCategoryImage(type: String): Int {
    return when (type) {
        CategoryType.CHILDREN.categoryName -> CategoryType.CHILDREN.imageResId
        CategoryType.ADULTS.categoryName -> CategoryType.ADULTS.imageResId
        CategoryType.ELDER.categoryName -> CategoryType.ELDER.imageResId
        CategoryType.ANIMALS.categoryName -> CategoryType.ANIMALS.imageResId
        CategoryType.EVENTS.categoryName -> CategoryType.EVENTS.imageResId
        else -> throw InvalidObjectException("Unknown category type : $type")
    }
}

@DrawableRes
fun getFriendAvatar(id: Long): Int {
    return when (id % 10) {
        0L, 5L -> R.drawable.photo_1
        1L, 6L -> R.drawable.photo_2
        2L, 7L -> R.drawable.photo_3
        3L, 8L -> R.drawable.photo_4
        4L, 9L -> R.drawable.photo_5
        else -> R.drawable.photo_5
    }
}

@DrawableRes
fun getArticleImage(id: Long): Int {
    if (id % 2 == 0L) {
        return KID_IMAGE_RES
    } else {
        return GUITAR_IMAGE_RES
    }
}


enum class NewsType(val type: String) {
    SINGLE_DAY("single_day"), TIME_PERIOD("time_period")
}

enum class CategoryType(@DrawableRes val imageResId: Int, val categoryName: String) {
    CHILDREN(R.drawable.girl, "children"),
    ADULTS(R.drawable.man, "adults"),
    ELDER(R.drawable.grandma, "elder"),
    ANIMALS(R.drawable.cat, "animals"),
    EVENTS(R.drawable.shoe, "events")
}