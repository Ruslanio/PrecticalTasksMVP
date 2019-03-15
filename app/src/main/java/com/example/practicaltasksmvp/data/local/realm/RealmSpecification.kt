package com.example.practicaltasksmvp.data.local.realm

import com.example.practicaltasksmvp.data.local.DbManager.Companion.EVERY_CATEGORY

sealed class Spec
class SingleArticleSpec(val byId: Long) : Spec()
class MultipleArticleSpec(val byCategoryId: Long) : Spec()
class CategorySpec : Spec()