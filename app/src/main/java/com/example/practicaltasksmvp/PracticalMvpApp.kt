package com.example.practicaltasksmvp

import android.app.Activity
import android.app.Application
import com.example.practicaltasksmvp.di.DaggerAppComponent
import com.example.practicaltasksmvp.di.modules.app.ContextModule
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class PracticalMvpApp : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        AndroidThreeTen.init(this)

        DaggerAppComponent
            .builder()
            .application(this)
            .contextModule(ContextModule(this))
            .build()
            .inject(this)
    }
}