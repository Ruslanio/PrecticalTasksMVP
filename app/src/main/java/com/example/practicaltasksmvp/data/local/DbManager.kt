package com.example.practicaltasksmvp.data.local

import com.example.practicaltasksmvp.data.local.realm.async.executors.ExecutionCallback
import com.example.practicaltasksmvp.data.local.realm.async.executors.ExecutorManager
import com.example.practicaltasksmvp.data.local.realm.entity.HelpCategory
import com.example.practicaltasksmvp.data.local.realm.impl.RealmFriendRepository
import com.example.practicaltasksmvp.data.local.realm.impl.RealmHelpCategoryRepository
import com.example.practicaltasksmvp.data.local.realm.impl.RealmNewsArticleRepository
import com.example.practicaltasksmvp.data.local.realm.impl.RealmPhoneRepository
import com.example.practicaltasksmvp.data.mappers.mapToEntity
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity
import io.realm.Realm
import io.realm.RealmConfiguration

class DbManager(config : RealmConfiguration) {

    companion object {
        const val EVERY_CATEGORY = -1L
    }

    private val executorHandler = ExecutorManager()

    private val newsRepo = RealmNewsArticleRepository(config)
    private val categoriesRepo = RealmHelpCategoryRepository(config)
    private val friendsRepo = RealmFriendRepository(config)
    private val phoneRepo = RealmPhoneRepository(config)


    fun getNewsArticles(
        categoryId: Long = EVERY_CATEGORY,
        executionCallback: ExecutionCallback<List<NewsArticleEntity>>
    ) {
        executorHandler.doInBackgroundWithResult({

            val res = when (categoryId) {
                EVERY_CATEGORY -> newsRepo.getAll().toList()
                else -> newsRepo.getArticlesByCategoryId(categoryId).toList()
            }
            return@doInBackgroundWithResult res.map(::mapToEntity)
        }, executionCallback)
    }

    fun getNewsArticleById(articleId: Long, executionCallback: ExecutionCallback<NewsArticleEntity>) {
        executorHandler.doInBackgroundWithResult({

            val res = newsRepo.getById(articleId)
            if (res != null) {
                res.phoneNumbers = phoneRepo.getByArticleId(res.id)
                res.likedFriends = friendsRepo.getByArticleId(res.id)
            }
            return@doInBackgroundWithResult mapToEntity(res)
        }, executionCallback)
    }

    fun getCategories(executionCallback: ExecutionCallback<List<HelpCategoryEntity>>) {
        executorHandler.doInBackgroundWithResult({
            return@doInBackgroundWithResult categoriesRepo.getAll().toList().map(::mapToEntity)
        }, executionCallback)
    }


    fun addCategoriesListToDb(objects: List<HelpCategory>) {
        executorHandler.doInBackground {

            categoriesRepo.addAll(objects)
            for (category in objects) {
                newsRepo.addAll(category.articles)
                category.articles.forEach {
                    friendsRepo.addAll(it.likedFriends)
                    phoneRepo.addAll(it.phoneNumbers)
                }
            }
        }
    }
}