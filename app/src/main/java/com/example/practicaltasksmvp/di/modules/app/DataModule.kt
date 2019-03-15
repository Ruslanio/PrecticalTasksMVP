package com.example.practicaltasksmvp.di.modules.app

import com.example.practicaltasksmvp.data.local.DbManager
import com.example.practicaltasksmvp.data.remote.ApiManager
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DataModule {

    private val config = Realm.getDefaultConfiguration()

    @Singleton
    @Provides
    fun provideApiManager() : ApiManager{
        return ApiManager()
    }

    @Singleton
    @Provides
    fun provideDbManager() : DbManager{
        return DbManager(config!!)
    }
}