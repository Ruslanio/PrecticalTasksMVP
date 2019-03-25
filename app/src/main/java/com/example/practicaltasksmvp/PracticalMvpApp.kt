package com.example.practicaltasksmvp

import com.example.practicaltasksmvp.di.DaggerAppComponent
import com.example.practicaltasksmvp.di.modules.app.ContextModule
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration

class PracticalMvpApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .contextModule(ContextModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        AndroidThreeTen.init(this)


    }
}