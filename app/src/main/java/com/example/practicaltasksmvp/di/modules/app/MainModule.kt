package com.example.practicaltasksmvp.di.modules.app

import android.content.Context
import com.example.practicaltasksmvp.data.DataManager
import com.example.practicaltasksmvp.data.local.DbManager
import com.example.practicaltasksmvp.data.remote.ApiManager
import com.example.practicaltasksmvp.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule::class, NavigationModule::class, ContextModule::class])
class MainModule {

    @Singleton
    @Provides
    fun provideDataManager(apiManager: ApiManager, dbManager: DbManager, @ApplicationContext context: Context): DataManager {
        return DataManager(context, apiManager, dbManager)
    }
}