package com.example.practicaltasksmvp.data

import android.annotation.SuppressLint
import android.content.Context
import com.example.practicaltasksmvp.data.local.DbManager
import com.example.practicaltasksmvp.data.local.DbManager.Companion.EVERY_CATEGORY
import com.example.practicaltasksmvp.data.local.realm.CategorySpec
import com.example.practicaltasksmvp.data.local.realm.MultipleArticleSpec
import com.example.practicaltasksmvp.data.local.realm.SingleArticleSpec
import com.example.practicaltasksmvp.data.local.realm.Spec
import com.example.practicaltasksmvp.data.local.realm.async.executors.ExecutionCallback
import com.example.practicaltasksmvp.data.mappers.mapPojoData
import com.example.practicaltasksmvp.data.mappers.mapToEntity
import com.example.practicaltasksmvp.data.remote.ApiManager
import com.example.practicaltasksmvp.data.remote.pojo.HelpCategoryPojo
import com.example.practicaltasksmvp.mvp.model.HelpCategoryEntity
import com.example.practicaltasksmvp.mvp.model.NewsArticleEntity

class DataManager(private val context: Context, private val apiManager: ApiManager, private val dbManager: DbManager) {


    @SuppressLint("CheckResult")
    fun <T> updateData(executionCallback: ExecutionCallback<T>, spec: Spec) {
        executionCallback.onExecutionStart()
        apiManager.getData()
            .subscribe(
                { result: List<HelpCategoryPojo>? ->
                    if (result != null) {
                        saveData(result)
                        when (spec) {
                            is SingleArticleSpec -> executionCallback.onExecutionComplete(
                                extractArticle(
                                    result,
                                    spec.byId
                                ) as T
                            )
                            is MultipleArticleSpec -> executionCallback.onExecutionComplete(
                                extractArticles(
                                    result,
                                    spec.byCategoryId
                                ) as T
                            )
                            is CategorySpec -> executionCallback.onExecutionComplete(extractCategories(result) as T)
                        }
                    }
                }
                , { error: Throwable? ->
                    error?.printStackTrace()
                })
    }

    fun getCategories(
        forceLoad: Boolean,
        executionCallback: ExecutionCallback<List<HelpCategoryEntity>>
    ) {
        if (forceLoad) {
            updateData(executionCallback, CategorySpec())
        } else {
            dbManager.getCategories(executionCallback)
        }
    }

    fun getArticles(
        categoryId: Long = EVERY_CATEGORY,
        forceLoad: Boolean,
        executionCallback: ExecutionCallback<List<NewsArticleEntity>>
    ) {
        if (forceLoad) {
            updateData(executionCallback, MultipleArticleSpec(categoryId))
        } else {
            dbManager.getNewsArticles(categoryId, executionCallback)
        }
    }

    fun getArticleById(
        articleId: Long, forceLoad: Boolean,
        executionCallback: ExecutionCallback<NewsArticleEntity>
    ) {
        if (forceLoad) {
            updateData(executionCallback, SingleArticleSpec(articleId))
        } else {
            dbManager.getNewsArticleById(articleId, executionCallback)
        }
    }

    private fun saveData(data: List<HelpCategoryPojo>) {
        dbManager.addCategoriesListToDb(mapPojoData(context, data))
    }


    private fun extractArticles(data: List<HelpCategoryPojo>, categoryId: Long): List<NewsArticleEntity>? {
        if (categoryId == EVERY_CATEGORY) {
            return data
                .flatMap { helpCategoryPojo -> helpCategoryPojo.articles }
                .map { mapToEntity(context, it) }
        } else {
            return data
                .find { helpCategoryPojo -> helpCategoryPojo.id.toLong().equals(categoryId) }
                ?.articles?.map { mapToEntity(context, it) }
        }
    }

    private fun extractArticle(data: List<HelpCategoryPojo>, articleId: Long): NewsArticleEntity? {
        return data
            .flatMap { helpCategoryPojo -> helpCategoryPojo.articles }
            .map { mapToEntity(context, it) }
            .find { newsArticleEntity -> newsArticleEntity.id.toLong().equals(articleId) }
    }

    private fun extractCategories(data: List<HelpCategoryPojo>): List<HelpCategoryEntity> {
        return data.map { mapToEntity(it) }
    }
}

