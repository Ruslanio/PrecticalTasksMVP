package com.example.practicaltasksmvp.di.modules.app

import android.content.Context
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.data.local.DbManager
import com.example.practicaltasksmvp.data.remote.ApiManager
import com.example.practicaltasksmvp.di.builder.ActivityBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module(includes = [DataModule::class, NavigationModule::class])
class MainModule {

    @Inject
    @Singleton
    @Provides
    fun provideDataManager(apiManager: ApiManager, dbManager: DbManager, context: Context): DataManager {
        return DataManager(context, apiManager, dbManager)
    }
}